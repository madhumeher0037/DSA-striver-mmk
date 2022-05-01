import java.util.*;
public class Solution {
    public static int targetSum(int n, int target, int[] arr) {
    	// Write your code here.
		int totSum=0;
		for(int i=0;i<arr.length;i++) totSum+=arr[i];
		if((totSum-target)<0 || (totSum-target)%2==1) return 0;
		int s2 = (totSum-target)/2;
		int[][] dp = new int[n][s2+1];
		for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
		return findNumOfSubset(n-1,arr,s2,dp);
    }
	public static int findNumOfSubset(int ind,int[] arr,int target,int[][] dp){
		if(ind==0){
			if(target==0 && arr[ind]==0) return 2;
			if(target==0 || target==arr[ind]) return 1;
			return 0;
		}
		if(dp[ind][target]!=-1) return dp[ind][target];
		int notPick = findNumOfSubset(ind-1,arr,target,dp);
		int pick=0;
		if(arr[ind]<=target) pick = findNumOfSubset(ind-1,arr,target-arr[ind],dp);
		
		return dp[ind][target]=notPick+pick;
	}
}