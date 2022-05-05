// // Memoization

// import java.util.*;

// public class Solution {
//     public static int findWays(int num[], int tar) {
//         // Write your code here..
// 		int[][] dp = new int[num.length][tar+1];
// 		for(int j=0;j<dp.length;j++) Arrays.fill(dp[j],-1);
// 		return findNoOfWays(0,num,tar,dp);
//     }
	
// 	public static int findNoOfWays(int ind,int[] num,int tar,int[][] dp){
// 		if(tar==0) return 1;
// 		if(ind==num.length){
// 			if(tar==0) return 1;
// 			return 0;
// 		}
// 		if(dp[ind][tar]!=-1) return dp[ind][tar];
// 		int notPick = findNoOfWays(ind+1,num,tar,dp);
// 		int pick =0;
// 		if(tar-num[ind]>=0) pick = findNoOfWays(ind+1,num,tar-num[ind],dp);
		
// 		return dp[ind][tar]=pick+notPick;
// 	}
// }