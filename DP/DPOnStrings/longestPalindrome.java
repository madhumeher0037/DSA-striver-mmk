// memoization
import java.util.*;
public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		int len1 = s.length();
		int len2 = t.length();
		int[][] dp = new int[len1+1][len2+1];
		for(int i=0;i<=len1;i++) dp[i][0]=0;
		for(int i=0;i<=len2;i++) dp[0][i]=0;
		
		for(int ind1=1;ind1<=len1;ind1++){
			for(int ind2=1;ind2<=len2;ind2++){
				if(s.charAt(ind1-1)==t.charAt(ind2-1)) dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
				else dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
			}
		}
		return dp[len1][len2];
    }
}