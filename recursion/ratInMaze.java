// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> innerRes = new ArrayList<String>();
        findNoPath(m,0,0,innerRes,res,n);
        return res;
    }
    public static void findNoPath(int[][] m,int i,int j,List<String> innerRes,List<String> res,int n){
        if(i<0 || j<0 || i>=n || j>=n || m[i][j]==0) return;
        if(i==n-1 && j==n-1){
            res.add(slove(innerRes));
            return;
        }
        m[i][j]=0;
        innerRes.add("U");
        findNoPath(m,i-1,j,innerRes,res,n);
        innerRes.remove(innerRes.size()-1);
        
        innerRes.add("D");
        findNoPath(m,i+1,j,innerRes,res,n);
        innerRes.remove(innerRes.size()-1);
        
        innerRes.add("L");
        findNoPath(m,i,j-1,innerRes,res,n);
        innerRes.remove(innerRes.size()-1);
        
        innerRes.add("R");
        findNoPath(m,i,j+1,innerRes,res,n);
        innerRes.remove(innerRes.size()-1);
        m[i][j]=1;
        
        return;
    }
    public static String slove(List<String> l){
        String s ="";
        for(String i:l) s+=i;
        return s;
    }
}