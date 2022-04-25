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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        // while doing xor on every pair element becomes zero but two number are not.
        // because in these two distinct numbers contains 1's and 0's at diff positions leads to diff number 
        // so find the right most 1 in xor of all numbers,because that 1 bit is present in one number and is not present in other number
        int xor = nums[0];
        for(int i=1;i<nums.length;i++){
            xor^=nums[i];
        }
        int  right_bit = xor&~(xor-1); // to find the right most bit 1;
        // System.out.println(right_bit);
       int[] res = new int[2];
       int x=0;
       int y=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&right_bit)>0){ // whichever number has the bit 1 at same index xor with x;
                x=x^nums[i];
            }
            else{ // if not xor with y;
                y=y^nums[i];
            }
        }
        res[0]=x;
        res[1]=y;
        Arrays.sort(res);
        return res;
    }
}