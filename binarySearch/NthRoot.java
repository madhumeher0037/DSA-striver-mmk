// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        double low=1,high=m;
        while((high-low)>1e-6){
            double mid = (low+high)/2;
            if(mult(mid,n)>m) high = mid;
            else low=mid;
        }
        double res = Math.ceil(low);
        // System.out.println(low+" "+res);
        return mult(res,n)==m?(int)res:-1;
    }
    public double mult(double mid,int n){
        double res=1.0;
        for(int i=0;i<n;i++) res*=mid;
        return res;
    }
}