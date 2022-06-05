class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0,m=matrix.length,n=matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0') continue;
                int cnt = findArea(i,j,m,n,matrix,dp);
//              area of square = cnt^2
                maxArea = Math.max(maxArea,cnt*cnt);
            }
        }
        return maxArea;
    }
    
    public static int findArea(int i,int j,int m,int n,char[][] mat,int[][] dp){
        if(i>=m || j>=n || mat[i][j]=='0') return 0;
        if(dp[i][j]!=-1) return dp[i][j];
//         Try to explore the matrix in a diaginally,where we check the corresponding row and col values.
//         When we get any zero in our path,we are going to neglect the all diagonal rows and cols after the zero element.
//         Including the current diagonal ele which having zero character.
//         And we are the counting the all diagonal paths which contains only the ones.
        int sum = 1+Math.min(Math.min(findArea(i+1,j,m,n,mat,dp),findArea(i,j+1,m,n,mat,dp)),findArea(i+1,j+1,m,n,mat,dp));
        return dp[i][j]=sum;
    }
}