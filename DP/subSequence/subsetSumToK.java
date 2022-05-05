
// // Java program to fill a subarray of given array
// // memoization
// import java.util.*;
// public class Solution {
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         // Write your code here.
// 		int[][] dp = new int[n][k+1];
// 		for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
// 		return findsubsetSumToK(n-1,k,arr,dp);
//     }
// 	public static boolean findsubsetSumToK(int ind,int target,int[] arr,int[][] dp){
// 		if(target==0) return true;
// 		if(ind==0){
// 			if(arr[ind]==target) return true;
// 			return false;
// 		}
// 		if(dp[ind][target]!=-1) return dp[ind][target]==1?true:false;
// 		boolean take=false;
// 		if(arr[ind]<=target)  take = findsubsetSumToK(ind-1,target-arr[ind],arr,dp);
// 		boolean notTake = findsubsetSumToK(ind-1,target,arr,dp);
// 		dp[ind][target]= (take || notTake)==true?1:0;
// 		return take || notTake;
// 	}
// }

// // Tabulation

// // Java program to fill a subarray of given array
// import java.util.*;
// public class Solution {
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         // Write your code here.
// 		boolean[][] dp = new boolean[n][k+1];
// 		for(int i=0;i<n;i++) dp[i][0]=true;
// 		if(arr[0]<=k) dp[0][arr[0]]=true;
// 		for(int ind=1;ind<n;ind++){
// 			for(int target=1;target<=k;target++){
// 				boolean take=false;
// 				if(arr[ind]<=target) take = dp[ind-1][target-arr[ind]];
// 				boolean notTake = dp[ind-1][target];
// 				dp[ind][target]= take || notTake;
// 			}
// 		}
// 		return dp[n-1][k];
//     }
// }

// // space optimization

// // Java program to fill a subarray of given array
// import java.util.*;
// public class Solution {
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         // Write your code here.
// 		boolean[] prev = new boolean[k+1];
// 		prev[0]=true;
// 		if(arr[0]<=k) prev[arr[0]]=true;
// 		for(int ind=1;ind<n;ind++){
// 			boolean[] curr = new boolean[k+1];
// 			curr[0]=true;
// 			for(int target=1;target<=k;target++){
// 				boolean take=false;
// 				if(arr[ind]<=target) take = prev[target-arr[ind]];
// 				boolean notTake = prev[target];
// 				curr[target]= take || notTake;
// 			}
// 			prev=curr;
// 		}
// 		return prev[k];
//     }
// }
