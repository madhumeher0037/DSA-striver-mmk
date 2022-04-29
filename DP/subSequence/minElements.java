// here time complexity is not 2^n because here while picking we are not Changing the ind,so we can say that the time complexity is exponential
// memoization
// import java.util.*;
// public class Solution {
//     public static int minimumElements(int num[], int x) {
//         // Write your code here..
// 		int n = num.length;
// 		int[][] dp = new int[n][x+1];
// 		for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
// 		int res = findMinEle(n-1,num,x,dp);
// 		return res==Integer.MAX_VALUE-1?-1:res;
//     }
// 	public static int findMinEle(int ind,int[] num,int tar,int[][] dp){
// 		if(tar==0){
// 			return 0;
// 		}
// 		if(ind==0){
// 			if(tar%num[ind]==0) return tar/num[ind];
// 			return Integer.MAX_VALUE-1;
// 		}
// 		if(dp[ind][tar]!=-1) return dp[ind][tar];
// 		int notPick = 0+findMinEle(ind-1,num,tar,dp);
// 		int pick = Integer.MAX_VALUE;
// 		if(num[ind]<=tar) pick=1+findMinEle(ind,num,tar-num[ind],dp);
// 		return dp[ind][tar]=Math.min(notPick,pick);
// 	}

// }
// tabulation
// import java.util.*;
// public class Solution {
//     public static int minimumElements(int num[], int x) {
//         // Write your code here..
// 		int n = num.length;
// 		int[][] dp = new int[n][x+1];
// 		for(int i=0;i<n;i++) dp[i][0]=0;
// 		for(int i=0;i<=x;i++){
// 			if(i%num[0]==0) dp[0][i]=i/num[0];
// 			else dp[0][i]=Integer.MAX_VALUE-1;
// 		}
// 		for(int ind=1;ind<n;ind++){
// 			for(int tar= 0;tar<=x;tar++){
// 				int notPick = 0+dp[ind-1][tar];
// 				int pick = Integer.MAX_VALUE;
// 				if(num[ind]<=tar) pick=1+dp[ind][tar-num[ind]];
// 				dp[ind][tar]=Math.min(notPick,pick);
// 			}
// 		}
// 		return dp[n-1][x]==Integer.MAX_VALUE-1?-1:dp[n-1][x];
//     }
// }