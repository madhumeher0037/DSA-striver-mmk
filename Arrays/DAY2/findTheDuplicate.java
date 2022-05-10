class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int ind = Math.abs(nums[i]);
            if(nums[ind]<0){
                change(nums);
                return ind;
            }
            else nums[ind]*=-1;
        }
        return 0;
    }
    public static void change(int[] nums){
        for(int i=0;i<nums.length;i++) if(nums[i]<0) nums[i]*=-1;
    }
}