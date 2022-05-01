// memoization
// import java.util.*;
// public class Solution {
// 	public static int cutRod(int price[], int n) {
// 		// Write your code here.
// 		int len = price.length;
// 		int[][] dp = new int[len][n+1];
// 		for(int i=0;i<len;i++) Arrays.fill(dp[i],-1);
// 		return findRodMax(len-1,price,n,dp);
// 	}
// 	public static int findRodMax(int ind,int[] prices,int target,int[][] dp){
// 		if(target==0) return 0;
		
// 		if(ind==0){
// 			return (target/(ind+1))*prices[ind];
// 		}
// 		if(dp[ind][target]!=-1) return dp[ind][target];
// 		int notPick = 0+findRodMax(ind-1,prices,target,dp);
// 		int pick = Integer.MIN_VALUE;
// 		int rodLen=ind+1;
// 		if(rodLen<=target) pick = prices[ind]+findRodMax(ind,prices,target-rodLen,dp);
// 		return dp[ind][target]=Math.max(notPick,pick);
// 	}
// }
// tabulation
// import java.util.*;
// public class Solution {
// 	public static int cutRod(int price[], int n) {
// 		// Write your code here.
// 		int len = price.length;
// 		int[][] dp = new int[len][n+1];
// 		for(int i=0;i<=n;i++) dp[0][i]=i*price[0];
// 		for(int ind=1;ind<len;ind++){
// 			for(int target=0;target<=n;target++){
// 				int notPick = 0+dp[ind-1][target];
// 				int pick = Integer.MIN_VALUE;
// 				int rodLen=ind+1;
// 				if(rodLen<=target) pick = price[ind]+dp[ind][target-rodLen];
// 				dp[ind][target]=Math.max(notPick,pick);
// 			}
// 		}
// 		return dp[len-1][n];
// 	}
// }
// space optimization
// import java.util.*;
// public class Solution {
// 	public static int cutRod(int price[], int n) {
// 		// Write your code here.
// 		int len = price.length;
// 		int[] prev = new int[n+1];
// 		int[] curr = new int[n+1];
// 		for(int i=0;i<=n;i++) prev[i]=i*price[0];
// 		for(int ind=1;ind<len;ind++){
// 			for(int target=0;target<=n;target++){
// 				int notPick = 0+prev[target];
// 				int pick = Integer.MIN_VALUE;
// 				int rodLen=ind+1;
// 				if(rodLen<=target) pick = price[ind]+curr[target-rodLen];
// 				curr[target]=Math.max(notPick,pick);
// 			}
// 			prev=curr;
// 		}
// 		return prev[n];
// 	}
// }