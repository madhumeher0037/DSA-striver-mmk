// import java.util.*;
// memoization
// public class Solution {
// 	public static boolean canPartition(int[] arr, int n) {
// 		// Write your code here.
// // 		List<Integer> pickInd = new ArrayList<Integer>();
// 		int sum=0;
// 		for(int i=0;i<arr.length;i++) sum+=arr[i];
// 		if(sum%2==1) return false;
// 		int[][] dp = new int[n][(sum/2)+1];
// 		for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
// 		return findPossible(n-1,sum/2,arr,dp);
// 	}
// 	public static boolean findPossible(int ind,int target,int[] arr,int[][] dp){
// 		if(target==0) return true;
// 		if(ind==0){
// 			if(arr[ind]==target) return true;
// 			return false;
// 		}
		
// 		if(dp[ind][target]!=-1) return dp[ind][target]==1?true:false;
// 		boolean pick = false;
// 		if(arr[ind]<=target) pick = findPossible(ind-1,target-arr[ind],arr,dp);
		
// 		boolean dontPick = findPossible(ind-1,target,arr,dp);
		
// 		dp[ind][target] = (pick||dontPick)==true?1:0;
// 		return pick || dontPick;
// 	}
// }
// tabulation
// import java.util.*;
// public class Solution {
// 	public static boolean canPartition(int[] arr, int n) {
// 		// Write your code here.
// // 		List<Integer> pickInd = new ArrayList<Integer>();
// 		int sum=0;
// 		for(int i=0;i<arr.length;i++) sum+=arr[i];
// 		if(sum%2==1) return false;
// 		boolean[][] dp = new boolean[n][(sum/2)+1];
// 		for(int i=0;i<n;i++) dp[i][0] =true;
// 		if(arr[0]<=(sum/2)) dp[0][arr[0]]=true;
		
// 		for(int ind=1;ind<n;ind++){
// 			for(int target=1;target<=(sum/2);target++){
// 				boolean pick = false;
// 				if(arr[ind]<=target) pick = dp[ind-1][target-arr[ind]];

// 				boolean dontPick = dp[ind-1][target];

// 				dp[ind][target] = (pick||dontPick);
// 			}
// 		}
// 		return dp[n-1][(sum/2)];
// 	}
// // 	public static boolean findPossible(int ind,int target,int[] arr,int[][] dp){
// // 		if(target==0) return true;
// // 		if(ind==0){
// // 			if(arr[ind]==target) return true;
// // 			return false;
// // 		}
		
// // 		if(dp[ind][target]!=-1) return dp[ind][target]==1?true:false;
		
// // 	}
// }
