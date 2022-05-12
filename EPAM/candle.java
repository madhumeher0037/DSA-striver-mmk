// /*
// For Siddarth's Birthday his friends planned cake cutting.
// On top of the cake there are two lines of candles, 
// all the candles with different heights. 
// The lines are prallel lines, line-P and line-Q .
// Siddarth has to blow all the candles in one go.

// So, he can swap one candle at a time, from P and Q and 
// the position of the candles in their line should be the same.

// At the end of the swaps, The candles in set P and set Q, 
// should be in ascending order of their heights.

// You will be heights of the candles initially in P and Q, after placing them in parallel lines.

// Your task is to find the minimum number of swaps required
// to arrange the candles in P and Q in ascending order.

// Note: It is guaranteed that the answer is always possible.

// Input Format:
// -------------
// Line-1: An integer N, num of candles in P and Q.
// Line-2: N space separated integers, heights of the candles in Line-P.
// Line-3: N space separated integers, heights of the candles in Line-Q.

// Output Format:
// --------------
// Print an integer, minimum number of swaps required.


// Sample Input-1:
// ---------------
// 4
// 1 3 5 4
// 1 2 3 7

// Sample Output-1:
// ----------------
// 1

// Explanation:
// ------------
// Swap the 4th candle in P and Q. 
// Then the heights of the candles in P = [1, 3, 5, 7],  Q = [1, 2, 3, 4]
// Both are in ascending order.

import java.util.*;

class Test{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        int[] q = new int[n];
        for(int i=0;i<n;i++) p[i]=sc.nextInt();
        for(int i=0;i<n;i++) q[i]=sc.nextInt();
        System.out.println(findMin(0,0,p,q,n));
    }
    
    public static int findMin(int i,int j,int[] p,int[] q,int n){
        if(i==n || j==n){
            for(int indi=0;indi<n-1;indi++){
                if(p[indi]>p[indi+1] || q[indi]>q[indi+1]) return Integer.MAX_VALUE-1;
            }
            return 0;
        }
        int notSwaped = 0+findMin(i+1,j+1,p,q,n);
        int swaped = Integer.MAX_VALUE-1;
        swap(i,j,p,q);
        swaped=1+findMin(i+1,j+1,p,q,n);
        swap(i,j,p,q);
        return Math.min(notSwaped,swaped);
    }
    
    public static void swap(int i,int j,int[] p,int[] q){
        p[i]=p[i]+q[i];
        q[i]=p[i]-q[i];
        p[i]=p[i]-q[i];
    }
}

