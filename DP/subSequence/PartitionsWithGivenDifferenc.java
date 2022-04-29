import java.util.*;

public class Solution {
	static int mod =(int)(Math.pow(10,9)+7);
	public static int findNoOfWays(int ind,int[] num,int tar,int[][] dp){
		if(ind==0){
			if(tar==0 && num[ind]==0) return 2;
			else if(tar==0 || num[ind]==tar) return 1;
			return 0;
		}
		if(dp[ind][tar]!=-1) return dp[ind][tar];
		int notPick = findNoOfWays(ind-1,num,tar,dp);
		int pick =0;
		if(tar-num[ind]>=0) pick = findNoOfWays(ind-1,num,tar-num[ind],dp);
		
		return dp[ind][tar]=(pick+notPick)%mod;
	}
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int totSum=0;
		for(int i=0;i<n;i++) totSum+=arr[i];
		if(totSum-d<0) return 0;
		if((totSum-d)%2==1) return 0;
		int tar = (totSum-d)/2;
		int[][] dp = new int[arr.length][tar+1];
		for(int j=0;j<dp.length;j++) Arrays.fill(dp[j],-1);
		return findNoOfWays(n-1,arr,tar,dp);
	}
}