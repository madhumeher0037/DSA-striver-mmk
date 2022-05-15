class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][] dp = new int[n][n];
        String res="";
        

        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<s.length();i++,j++){
                if(gap==0){
//                     if it is single character means its a palindrome,store true in dp.
                    dp[i][j]=1;
                }
                else if(gap==1){
//                     if it is two characters means its a palindrome,store true in dp.
                    if(s.charAt(i)==s.charAt(j)) dp[i][j]=1;
                }
                else{
//                    compare the boundary char's and if inner subString(i+1,j-1) is palindrome the whole string is palindrome.

                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1) dp[i][j]=1;
                }
//                 each time the gap is constant ,at specific gap if we found palindrome then its current longest palindrome.
//                 subsequently on each gaps we find the longest palindrome.
                if(dp[i][j]==1) res = s.substring(i,j+1);
            }
        }
        return res;
    }
}