// // Understood bhaiya!! In short we can say that the dp table last row defines whether the target value is possible from given 
// // array or not.Then all possible target values are derived from the dp table and we can take min diff among the all abs diff. 
// public class Solution {
// 	public static int minSubsetSumDifference(int[] arr, int n) {
// 		// Write your code here.
// 		int k=0;
// 		for(int i=0;i<arr.length;i++) k+=arr[i];
		
// 		boolean[][] dp = new boolean[n][k+1];
// 		for(int i=0;i<n;i++) dp[i][0]=true;
// 		if(arr[0]<=k) dp[0][arr[0]]=true;
		
// 		for(int i=1;i<n;i++){
// 			for(int target =1;target<=k;target++){
// 				boolean pick = false;
// 				if(arr[i]<=target) pick = dp[i-1][target-arr[i]];
// 				boolean notPick = dp[i-1][target];
// 				dp[i][target]=(pick||notPick);
// 			}
// 		}
// 		int res = Integer.MAX_VALUE;
// 		for(int i=0;i<=k/2;i++){
// 			if(dp[n-1][i]){
// 				int s1 = i;
// 				int s2 = (k-i);
// 				res = Math.min(res,Math.abs(s1-s2));
// 			}
// 		}
// 		return res;
// 	}
// }
