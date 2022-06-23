class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        for(int i=0;i<n;i++){
            int start=0;
            int last=m-1;
            while(start<=last){
                int temp = matrix[i][start];
                matrix[i][start]=matrix[i][last];
                matrix[i][last]=temp;
                start++;
                last--;
            }
        }
    }
}