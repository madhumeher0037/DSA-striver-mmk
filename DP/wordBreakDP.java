// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        int[][] dp = new int[A.length()][A.length()];
        for(int i=0;i<A.length();i++) Arrays.fill(dp[i],-1);
        return findWord(0,0,A,B,dp);
    }
    
    public static int findWord(int ind1,int ind2,String A,ArrayList<String> B,int[][] dp){
        if(ind2==A.length()-1){
            if(B.contains(A.substring(ind1,ind2+1))) return 1;
            return 0;
        }
        
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        
        int a = 0;
        if(B.contains(A.substring(ind1,ind2+1))) a = findWord(ind2+1,ind2+1,A,B,dp);
        int b = findWord(ind1,ind2+1,A,B,dp);
        
        return dp[ind1][ind2]=(a|b);
    }
}