class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> innerList= new ArrayList<Integer>();
        boolean[] f = new boolean[nums.length];
        findPermutation(nums,ans,innerList,f);
        return ans;
    }
    public static void findPermutation(int[] nums,List<List<Integer>> ans,List<Integer> innerList,boolean[] f){
        int n=nums.length;
        if(innerList.size()==n){
            ans.add(new ArrayList<Integer>(innerList));
            return;
        }
        for(int i=0;i<n;i++){
            if(!f[i]){
                f[i]=true;
                innerList.add(nums[i]);
                findPermutation(nums,ans,innerList,f);
                innerList.remove(innerList.size()-1);
                f[i]=false;
            }
        }
        return;
    }
}