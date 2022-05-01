public class Solution {
    public static int minInsertion(String str) {
    	// Write your code here.
		int len = str.length();
		String revS="";
		for(int k=len-1;k>=0;k--) revS+=str.charAt(k);
		int[][] dp = new int[len+1][len+1];
		for(int i=0;i<=len;i++) dp[i][0]=0;
		for(int i=0;i<=len;i++) dp[0][i]=0;
		for(int ind1=1;ind1<=len;ind1++){
			for(int ind2=1;ind2<=len;ind2++){
				if(str.charAt(ind1-1)==revS.charAt(ind2-1)) dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
				else dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
			}
		}
		return len - dp[len][len];
    }
}

// For minimum number of deletion to make string as palindrome is also same.In above problem we are just returning the min 
// no of insertion to make it as palindrome.if remove/delete the non-palindromic characters from string having longest palindromic subsequence,then
// string becomes the palindrome