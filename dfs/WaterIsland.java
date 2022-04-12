import java.util.*;

class Test{
    public static void dfs(int[][] mat,int i,int j){
        int n = mat.length,m=mat[0].length;
        if( i<0 || j<0 || i>=n || j >=m || mat[i][j] ==0 || mat[i][j] ==-1 ) return;
        
        mat[i][j]=-1;
        
        dfs(mat,i-1,j);
        dfs(mat,i+1,j);
        dfs(mat,i,j-1);
        dfs(mat,i,j+1);
        
        return;
    }
    public static void main(String[] args){
        int n,m,p;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int i=0;i<p;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            mat[x][y]=1;
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    dfs(mat,i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        return;
    }
}