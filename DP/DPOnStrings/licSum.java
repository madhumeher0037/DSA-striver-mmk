// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java
// Adding previous increasing sum to curr num,Store the curr num so that we can't override it
class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int[] lis = new int[arr.length];
	    int[] maxSum = new int[arr.length];
	    for(int i=0;i<arr.length;i++) maxSum[i]=arr[i];
	    Arrays.fill(lis,1);
	    int maxLIS = Integer.MIN_VALUE;
	    for(int i=0;i<arr.length;i++){
	        int temp = maxSum[i];
	        for(int j=0;j<i;j++){
	            if(arr[j]<arr[i]){
	                lis[i]=Math.max(lis[i],lis[j]+1);
	                maxSum[i] = Math.max(maxSum[i],temp+maxSum[j]);
	            }
	        }
	        maxLIS = Math.max(maxLIS,maxSum[i]);
	    }
	    return maxLIS;
	}  
}