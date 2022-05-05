// Memoization
class Solution {
    public int minDistance(String word1, String word2) {
        //         To memoize subproblems use the dp 
        //         why word1 and word2 length?
        //         because they are the changing parameters in recursion
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++) Arrays.fill(dp[i],-1);
        return findMinDis(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
    
    public int findMinDis(int n,int m,String w1,String w2,int[][] dp){
        //         if w1 is exahausted then we have to add the remaining characters of w2 to string w1
        if(n<0 && m>=0) return m+1;
        //         if w2 is exahausted then we have to remove the remaining characters of w1
        if(n>=0 && m<0) return n+1;
        //         if both are exhausted then we constructed the s2 string with s1 string
        if(n<0 && m<0) return 0;
        
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(w1.charAt(n)==w2.charAt(m)) return dp[n][m]= 0+findMinDis(n-1,m-1,w1,w2,dp);
        
        //         inserting a new char will cost 1 and w1 index will not change
        int insert = 1+findMinDis(n,m-1,w1,w2,dp);
        //         delete a new char will cost 1 and w1 index will not change
        int delete = 1+findMinDis(n-1,m,w1,w2,dp);
        //         replace a new char will cost 1 and w1 and w2 index will not change
        int replace = 1+findMinDis(n-1,m-1,w1,w2,dp);
        
        return dp[n][m]=Math.min(Math.min(insert,delete),replace);
    }
}


// same as above one but right shifted
class Solution {
    public int minDistance(String word1, String word2) {
        //         To memoize subproblems use the dp 
        //         why word1 and word2 length?
        //         because they are the changing parameters in recursion
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++) Arrays.fill(dp[i],-1);
        return findMinDis(word1.length(),word2.length(),word1,word2,dp);
    }
    
    public int findMinDis(int n,int m,String w1,String w2,int[][] dp){
        //         if w1 is exahausted then we have to add the remaining characters of w2 to string w1
        if(n==0 && m>0) return m;
        //         if w2 is exahausted then we have to remove the remaining characters of w1
        if(n>0 && m==0) return n;
        //         if both are exhausted then we constructed the s2 string with s1 string
        if(n==0 && m==0) return 0;
        
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(w1.charAt(n-1)==w2.charAt(m-1)) return dp[n][m]= 0+findMinDis(n-1,m-1,w1,w2,dp);
        
        //         inserting a new char will cost 1 and w1 index will not change
        int insert = 1+findMinDis(n,m-1,w1,w2,dp);
        //         delete a new char will cost 1 and w1 index will not change
        int delete = 1+findMinDis(n-1,m,w1,w2,dp);
        //         replace a new char will cost 1 and w1 and w2 index will not change
        int replace = 1+findMinDis(n-1,m-1,w1,w2,dp);
        
        return dp[n][m]=Math.min(Math.min(insert,delete),replace);
    }
}
// Tabulation
class Solution {
    public int minDistance(String word1, String word2) {
        //         To memoize subproblems use the dp 
        //         why word1 and word2 length?
        //         because they are the changing parameters in recursion
        int n = word1.length(),m=word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=m;i++) dp[0][i]=i;
        for(int i=0;i<=n;i++) dp[i][0]=i;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=0+dp[i-1][j-1];
                else{
                    //         inserting a new char will cost 1 and w1 index will not change
                    int insert = 1+dp[i][j-1];
                    //         delete a new char will cost 1 and w1 index will not change
                    int delete = 1+dp[i-1][j];
                    //         replace a new char will cost 1 and w1 and w2 index will not change
                    int replace = 1+dp[i-1][j-1];

                    dp[i][j]=Math.min(Math.min(insert,delete),replace);
                }
            }
        }
        
        return dp[n][m];
    }
}