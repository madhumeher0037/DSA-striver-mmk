// In substring,we are adding previos charcters values to next contigious chracter.if previous charcters are same then we adding them.
// we are ommting the charcters as we done in longestCommonSubsequence 

// by default they are intialise to zero are again intialising the row 0 and col 0
public class Solution {
	public static int lcs(String str1, String str2) {
		// Write your code here.
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dp = new int[len1+1][len2+1];
		int maxLen = Integer.MIN_VALUE;
		for(int ind1=1;ind1<=len1;ind1++){
			for(int ind2=1;ind2<=len2;ind2++){
				if(str1.charAt(ind1-1)==str2.charAt(ind2-1)) dp[ind1][ind2] = 1+dp[ind1-1][ind2-1];
				maxLen=Math.max(maxLen,dp[ind1][ind2]);
			}
		}
		return maxLen;
	}
}