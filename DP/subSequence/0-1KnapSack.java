// memoization
// import java.util.*;
// public class Solution{
//     static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

//             /* Your class should be named Solution
//             * Don't write main().
//             * Don't read input, it is passed as function argument.
//             * Change in the given tree itself.
//             * No need to return or print the output.
//             * Taking input and printing output is handled automatically.
//             */
// 			int[][] dp = new int[n][maxWeight+1];
// 			for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
// 			return findMaxValue(n-1,weight,value,maxWeight,dp);
//     }
	
// 	static int findMaxValue(int ind,int[] wt,int[] val,int maxWeight,int[][] dp){
// 		if(ind==0){
// 			if(wt[0]<=maxWeight) return val[ind];
// 			return 0;
// 		}
// 		if(dp[ind][maxWeight]!=-1) return dp[ind][maxWeight];
// 		int notPick = 0+findMaxValue(ind-1,wt,val,maxWeight,dp);
// 		int pick = Integer.MIN_VALUE;
// 		if(wt[ind]<=maxWeight) pick = val[ind]+findMaxValue(ind-1,wt,val,maxWeight-wt[ind],dp);
		
// 		return dp[ind][maxWeight]=Math.max(pick,notPick);
// 	}
// }
// tabulation
// import java.util.*;
// public class Solution{
//     static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

//             /* Your class should be named Solution
//             * Don't write main().
//             * Don't read input, it is passed as function argument.
//             * Change in the given tree itself.
//             * No need to return or print the output.
//             * Taking input and printing output is handled automatically.
//             */
// 			int[][] dp = new int[n][maxWeight+1];
// 			for(int i=weight[0];i<=maxWeight;i++) dp[0][i]=value[0];
// 			for(int ind=1;ind<n;ind++){
// 				for(int wt=0;wt<=maxWeight;wt++){
// 					int notPick = 0+dp[ind-1][wt];
// 					int pick = Integer.MIN_VALUE;
// 					if(weight[ind]<=wt) pick = value[ind]+dp[ind-1][wt-weight[ind]];
// 					dp[ind][wt]=Math.max(pick,notPick);
// 				}
// 			}
// 			return dp[n-1][maxWeight];
//     }
// }