class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] mat = new int[n][n];
        findNQueen(0,mat,res);
        return res;
    }
    public void findNQueen(int ind,int[][] mat,List<List<String>> res){
        if(ind>=mat.length){
            makeChess(mat,res);
            return;
        }
        
        for(int i=0;i<mat[0].length;i++){
            if(isDiagonalSafe(mat,ind,i)){
                mat[ind][i]=1;
                findNQueen(ind+1,mat,res);
                mat[ind][i]=0;
            }
        }
    }
    public void makeChess(int[][] mat,List<List<String>> res){
        List<String> innerRes = new ArrayList<String>();
        for(int i=0;i<mat.length;i++){
            String innerStr="";
            for(int j=0;j<mat[0].length;j++){
                innerStr+= mat[i][j]==1?"Q":".";
            }
            innerRes.add(innerStr);
        }
        res.add(innerRes);
    }
    public boolean isDiagonalSafe(int[][] mat,int row,int col){
        int tempRow = row,tempCol = col,n=mat.length;
//         check up side
        tempRow = row;
        tempCol = col;
        while(tempRow>=0){
            if(mat[tempRow][tempCol]==1) return false;
            tempRow--;
        }
//         check diagonally up left
        tempRow = row;
        tempCol = col;
        while(tempRow>=0 && tempCol>=0){
            if(mat[tempRow][tempCol]==1) return false;
            tempCol--;
            tempRow--;
        }
//          check diagonally up right
        tempRow = row;
        tempCol = col;
        while(tempRow>=0 && tempCol<n){
            if(mat[tempRow][tempCol]==1) return false;
            tempCol++;
            tempRow--;
        }
        
        return true;
    }
}