// Murali playing a mobile game, Blast the letters.

// In the game he is given a word W and value R.
// Murali has to perform the blasting operation as follows:
// 	- He has to blast the mimeograph M of length R in W, 
// 	  a mimeograph is a string such that each letter in it should be same.
// 	- After blasting the mimeograph, the rest of the string on its left side and right side, concatenated together.

// Murali has to perform the blasting operation repeatedly, until no more blasting is possible.

// Your task is to return the final string after all the blast operations have been done.

// Input Format:
// -------------
// Line-1: A string and an integer, W and R.

// Output Format:
// --------------
// Print a string, the final string after all the blast operations have been done.


// Sample Input-1:
// --------------- 
// ababbaaab 3

// Sample Output-1:
// ----------------
// aba

// Sample Input-2:
// --------------- 
// caaabbbaacdddd 2

// Sample Output-2:
// ----------------
// cabc



import java.util.*;
class pair{
    char c;
    int cnt;
    pair(char c,int cnt){
        this.c=c;
        this.cnt=cnt;
    }
}
class Test{
    public static void main(String[] args){
        String s;
        int r;
        Scanner sc = new Scanner(System.in);
        s=sc.next();
        r=sc.nextInt();
        Stack<pair> st = new Stack<pair>();
        
        for(int i=s.length()-1;i>=0;i--){
            if(!st.isEmpty() && st.peek().c==s.charAt(i)){
                pair p = st.pop();
                p.cnt++;
                // System.out.println(p.c+" "+p.cnt);
                if(p.cnt==r) continue;
                // System.out.println(p.c+" "+p.cnt);
                st.push(p);
            }
            else {
                pair p = new pair(s.charAt(i),1);
                st.push(p);
            }
        }
        String res="";
        while(!st.isEmpty()){
            char c= st.peek().c;
            for(int i=0;i<st.peek().cnt;i++) res+=c;
            st.pop();
        }
        System.out.println(res);
    }
}