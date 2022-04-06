class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1 && nums[0]!=target) return -1;
        int low=0,high=nums.length-1;
        int rotatedIndex=0;
        if(nums[low]<=nums[high]) return binarySearch(nums,low,high,target);
        rotatedIndex=findPeak(nums,low,high);
        if(nums[rotatedIndex]==target) return rotatedIndex;
        else if(nums[0]>target) return binarySearch(nums,rotatedIndex,high,target);
        else return binarySearch(nums,low,rotatedIndex,target);
    }
    public static int findPeak(int[] nums,int low,int high){
        while(low<=high){
            int pivot=(low+high)/2;
            if(nums[pivot]>nums[pivot+1]){
                return pivot+1;
            }
            else if(nums[pivot]<nums[low]){ 
                high = pivot-1;
            }
            else{
                low = pivot+1;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}