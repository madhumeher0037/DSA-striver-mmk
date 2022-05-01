
// on each recurrsion compare the curr index with the preIndex if currIndex greater than the previous guy,consider the curr guy(one possible match)
// if previndex greater than the curr guy the don't consider the curr guy move next index

// Memoization
// in this,we get TLE because n exits between 1 and 10^5 
// we using the dp of 10^5*10^5 that eventually a big size and gives a TLE
// public class Solution {

// 	public static int longestIncreasingSubsequence(int arr[]) {
// 		//Your code goes here
// 		int n = arr.length;
// 		return lic(0,-1,arr,n);
// 	}
	
// 	public static int lic(int currInd,int prevInd,int[] arr,int n){
// 		if(currInd==n) return 0;
		
// 		int notTake = lic(currInd+1,prevInd,arr,n);
		
// 		int take = Integer.MIN_VALUE;
// 		if(prevInd==-1 || arr[currInd]>arr[prevInd]) take=1+lic(currInd+1,currInd,arr,n);
		
// 		return Math.max(notTake,take);
// 	}

// }
// we can also use tabulation
// -> express the base conditions
// -> write no.of loops for all changing states
// -> copy recurrsion logic
// -> because we are using co-ordinate shift and take of co-ordinate shfit in bottom up appraoch/tabulation 

// There is a optimal approach TC:o(n^2) and SC:O(n)
// we store the prev lic lenght in the dp
// import java.util.*;

// public class Solution {

	// public static int longestIncreasingSubsequence(int arr[]) {
	// 	//Your code goes here
	// 	int n = arr.length;
	// 	int[] dp = new int[n];
	// 	Arrays.fill(dp,1);
	// 	int maxLicLen=1;
	// 	for(int curri=0;curri<n;curri++){
	// 		for(int previ=0;previ<curri;previ++){
	// 			if(arr[previ]<arr[curri]){
	// 				dp[curri]=Math.max(dp[curri],dp[previ]+1);
	// 			}
	// 		}
	// 		maxLicLen = Math.max(dp[curri],maxLicLen);
	// 	} 
	// 	return maxLicLen;
	// }
// }

// priting lic : https://www.youtube.com/watch?v=3mD20VSib5E&t=14s
// binary lic : https://www.youtube.com/watch?v=on2hvxBXJH4