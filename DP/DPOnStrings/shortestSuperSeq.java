public class Solution {
    public static String shortestSupersequence(String a, String b) {
		// Write your code here..
		int len1 = a.length();
		int len2 = b.length();
		int[][] dp = new int[len1+1][len2+1];
// 		instialiase the row 0 and col 0 with the all zeros to overcome the edge cases,
// 		by "default they are zero"
		
		for(int ind1=1;ind1<=len1;ind1++){
			for(int ind2=1;ind2<=len2;ind2++){
				if(a.charAt(ind1-1)==b.charAt(ind2-1)) dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
				else dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
			}
		}
		int i=len1,j=len2;
		String tempRes="",res="";
		while(i>0 && j>0){
// 			if both chars are equal then add only one character
			if(a.charAt(i-1)==b.charAt(j-1)){
				tempRes+=a.charAt(i-1);
				i=i-1;
				j=j-1;
			}
// 			if upper one is greater than the left one then add left guy move to up
			else if(dp[i-1][j]>dp[i][j-1]){
				tempRes+=a.charAt(i-1);
				i=i-1;
			}
// 			if upper one is lesser or equal left one then add upper guy move to left
			else{
				tempRes+=b.charAt(j-1);
				j=j-1;
			}
		}
// 		if a is not exhausted
		while(i>0){
			tempRes+=a.charAt(i-1);
			i=i-1;
		}
// 		if b is not exhausted
		while(j>0){
			tempRes+=b.charAt(j-1);
			j=j-1;
		}
// 		reverse the string
		for(int ind=tempRes.length()-1;ind>=0;ind--) res+=tempRes.charAt(ind);
		return res;
    }

}