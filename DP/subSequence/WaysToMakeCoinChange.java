// same as minimumElements but here we have count no of subsets
// import java.util.*;
// public class Solution {

// 	public static long countWaysToMakeChange(int denominations[], int value){
//         //write your code here	
// 		int n=denominations.length;
// 		long[][] dp = new long[n][value+1];
// 		for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
// 		return (long)findCountWays(n-1,denominations,value,dp);
// 	}
// 	public static long findCountWays(int ind,int[] wt,int target,long[][] dp){
// 		if(target==0) return 1;
// 		if(ind==0){
// 			if((target%wt[ind])==0) return 1;
// 			return 0;
// 		}
// 		if(dp[ind][target]!=-1) return dp[ind][target];
// 		long  notPick = findCountWays(ind-1,wt,target,dp);
// 		long pick = 0;
// 		if(wt[ind]<=target) pick=findCountWays(ind,wt,target-wt[ind],dp);
// 		return dp[ind][target]=notPick+pick;
// 	}
	
// }