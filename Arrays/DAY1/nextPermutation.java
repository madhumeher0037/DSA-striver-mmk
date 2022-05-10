class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j=n-1;
            while(j>=0 && nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
        rev(nums,i+1,n-1);
    }   
    public static void swap(int[] nums,int x,int y){
        int temp =nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
    public static void rev(int[] nums,int start,int end){
        while(start<=end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}