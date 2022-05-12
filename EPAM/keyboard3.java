// There is a keyboard consists of following keys only,

// Key 1: (S): Print one 'S' on screen.
// Key 2: (Ctrl-S): Select the whole screen.
// Key 3: (Ctrl-C): Copy selection to buffer.
// Key 4: (Ctrl-P): Print buffer on screen appending it after what has already been printed.

// Now, you can only press the keyboard for N times (with the above four keys), 
// find out the maximum numbers of 'S' you can print on screen.

// Example 1:
// Input:3
// Output: 3
// Explanation: 
// We can at most get 3 S's on screen by pressing following key sequence:
// S, S, S

// Example 2:
// Input: 7
// Output: 9
// Explanation: 
// We can at most get 9 S's on screen by pressing following key sequence:
// S, S, S, Ctrl S, Ctrl C, Ctrl P, Ctrl P

// case=1
// input=3
// output=3

// case=2
// input=7
// output=9

// case=3
// input=10
// output=20

// case=4
// input=15
// output=81

import java.util.*;

class Test{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findMax(n,0,1));
    }
    
    public static int findMax(int n,int currVal,int buffer){
        if(n==0) return currVal;
        int notPrint = findMax(n-1,currVal+buffer,buffer);
        int temp = buffer;
        buffer=currVal;
        int print = Integer.MIN_VALUE;
        if(n>=3) print = findMax(n-3,currVal+buffer,buffer);
        buffer=temp;
        // System.out.println(print+" "+notPrint);
        return Math.max(notPrint,print);
    }
}