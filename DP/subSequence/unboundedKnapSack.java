// the time complexity is exponential but not 2^n because on each recursion it is we are staying same index
// memoization
// import java.util.*;

// public class Solution {
//     public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
//         // Write your code here.
// 		int[][] dp = new int[n][w+1];
// 		for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
// 		int res = unboundKnapSack(n-1,w,profit,weight,dp);
// 		return res<=0?0:res;
//     }
// 	public static int unboundKnapSack(int ind,int target,int[] profit,int[] weight,int[][] dp){
// 		if(target==0) return 0;
// 		if(ind==0){
// 			return (target/weight[ind])*profit[ind];
// 		}
// 		if(dp[ind][target]!=-1) return dp[ind][target];
// 		int notPick = 0+unboundKnapSack(ind-1,target,profit,weight,dp);
// 		int pick=Integer.MIN_VALUE;
// 		if(weight[ind]<=target) pick=profit[ind]+unboundKnapSack(ind,target-weight[ind],profit,weight,dp);
		
// 		return dp[ind][target]=Math.max(notPick,pick);
// 	}
// // }
// tabulation
// import java.util.*;

// public class Solution {
//     public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
//         // Write your code here.
// 		int[][] dp = new int[n][w+1];
// 		for(int i=0;i<=w;i++) dp[0][i]=(i/weight[0])*profit[0];
// 		for(int ind=1;ind<n;ind++){
// 			for(int target=0;target<=w;target++){
// 				int notPick = 0+dp[ind-1][target];
// 				int pick=Integer.MIN_VALUE;
// 				if(weight[ind]<=target) pick=profit[ind]+dp[ind][target-weight[ind]];
// 				dp[ind][target]=Math.max(notPick,pick);
// 			}
// 		}
// 		return dp[n-1][w]<=0?0:dp[n-1][w];
//     }
// }
// space optimization
// import java.util.*;

// public class Solution {
//     public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
//         // Write your code here.
// 		int[] prev = new int[w+1];
// 		int[] curr = new int[w+1];
// 		for(int i=0;i<=w;i++) prev[i]=(i/weight[0])*profit[0];
// 		for(int ind=1;ind<n;ind++){
// 			for(int target=0;target<=w;target++){
// 				int notPick = 0+prev[target];
// 				int pick=Integer.MIN_VALUE;
// 				if(weight[ind]<=target) pick=profit[ind]+curr[target-weight[ind]];
// 				curr[target]=Math.max(notPick,pick);
// 			}
// 			prev=curr;
// 		}
// 		return prev[w]<=0?0:prev[w];
//     }
// }
