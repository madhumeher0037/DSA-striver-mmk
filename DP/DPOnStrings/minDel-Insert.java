public class Solution {
    public static int canYouMake(String str, String ptr) {
        // Write your code here.
		int len1=str.length();
		int len2=ptr.length();
		int[][] dp = new int[len1+1][len2+1];
		for(int i=0;i<=len1;i++) dp[i][0]=0;
		for(int i=0;i<=len2;i++) dp[0][i]=0;
		for(int ind1=1;ind1<=len1;ind1++){
			for(int ind2=1;ind2<=len2;ind2++){
				if(str.charAt(ind1-1)==ptr.charAt(ind2-1)) dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
				else dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
			}
		}
		int remove = str.length()-dp[len1][len2];
		int add = ptr.length()-dp[len1][len2];
		return remove+add;
	}
}
// the tabulation finds the longest common subsequence between two strings,after that remove non-common elements 
// from the str and add non-common elements from ptr to str