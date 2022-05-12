class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return findUniquePaths(m-1,n-1,dp);
    }
    
    public static int findUniquePaths(int m,int n,int[][] dp){
        if(m<0 || n<0) return 0;
        
        if(m==0 && n==0) return 1;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]=findUniquePaths(m-1,n,dp)+findUniquePaths(m,n-1,dp);   
    }
}