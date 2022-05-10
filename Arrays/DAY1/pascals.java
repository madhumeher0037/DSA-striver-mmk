class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<Integer>();
        for(int i=1;i<=numRows;i++){
            List<Integer> curr = new ArrayList<Integer>();
            for(int j=0;j<i;j++){
                if(j==0 || j==i-1) curr.add(1);
                else{
                    int currEle = prev.get(j-1)+prev.get(j);
                    curr.add(currEle);
                }
            }
            res.add(curr);
            prev=curr;
        }
        return res;
    }
}