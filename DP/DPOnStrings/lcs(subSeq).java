// memoization
// import java.util.*;
// public class Solution {

// 	public static int lcs(String s, String t) {
// 		//Your code goes here
// 		int len1 = s.length();
// 		int len2 = t.length();
// 		int[][] dp = new int[len1][len2];
// 		for(int i=0;i<len1;i++) Arrays.fill(dp[i],-1);
// 		return findComSubSeqLen(len1-1,len2-1,s,t,dp);
//     }
// 	public static int findComSubSeqLen(int ind1,int ind2,String s,String t,int[][] dp){
// 		if(ind1<0 || ind2<0) return 0;
// 		if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
// 		if(s.charAt(ind1)==t.charAt(ind2)) return dp[ind1][ind2]=1+findComSubSeqLen(ind1-1,ind2-1,s,t,dp);
		
// 		return dp[ind1][ind2]=Math.max(findComSubSeqLen(ind1-1,ind2,s,t,dp),findComSubSeqLen(ind1,ind2-1,s,t,dp));
// 	}
// }

// memoization with right shifted index
// import java.util.*;
// public class Solution {

// 	public static int lcs(String s, String t) {
// 		//Your code goes here
// 		int len1 = s.length();
// 		int len2 = t.length();
// 		int[][] dp = new int[len1+1][len2+1];
// 		for(int i=0;i<=len1;i++) Arrays.fill(dp[i],-1);
// 		return findComSubSeqLen(len1,len2,s,t,dp);
//     }
// 	public static int findComSubSeqLen(int ind1,int ind2,String s,String t,int[][] dp){
// 		if(ind1==0 || ind2==0) return 0;
// 		if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
// 		if(s.charAt(ind1-1)==t.charAt(ind2-1)) return dp[ind1][ind2]=1+findComSubSeqLen(ind1-1,ind2-1,s,t,dp);
		
// 		return dp[ind1][ind2]=Math.max(findComSubSeqLen(ind1-1,ind2,s,t,dp),findComSubSeqLen(ind1,ind2-1,s,t,dp));
// 	}
// }

// tabulation with right shifted index
// import java.util.*;
// public class Solution {

// 	public static int lcs(String s, String t) {
// 		//Your code goes here
// 		int len1 = s.length();
// 		int len2 = t.length();
// 		int[][] dp = new int[len1+1][len2+1];
// 		for(int i=0;i<=len1;i++) dp[i][0]=0;
// 		for(int i=0;i<=len2;i++) dp[0][i]=0;
		
// 		for(int ind1=1;ind1<=len1;ind1++){
// 			for(int ind2=1;ind2<=len2;ind2++){
// 				if(s.charAt(ind1-1)==t.charAt(ind2-1)) dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
// 				else dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
// 			}
// 		}
// 		return dp[len1][len2];
//     }
// }