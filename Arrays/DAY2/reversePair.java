// if you are still stuck with this problem.
// Try the below program, it is more intuitive.
// When arr[i]>2*arr[j] then cnt incremented to (mid-i+1)
// This means " all right ele of ith index including ith ele " are greater than 2*arr[j]. Then add all ele count to ans;
// And move the jth index to right.
// .
// .
// .
class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        int cnt = mergeSort(0,nums.length-1,nums,temp);
        return cnt;
    }
    
    public static int mergeSort(int low,int high,int[] nums,int[] temp){
        int cnt=0;
        if(low<high){
            int mid = (low+high)/2;
            cnt+=mergeSort(low,mid,nums,temp);
            cnt+=mergeSort(mid+1,high,nums,temp);
            int j=mid+1,i=low;
            while(i<=mid && j<=high){
                    if(nums[i]>2*(long)nums[j]){
                        cnt+=(mid-i+1);
                        j++;
                    }
                    else i++;
            }
            merge(low,mid,high,nums,temp);
        }
        return cnt;
    }
    
    public static void merge(int low,int mid,int high,int[] nums,int[] temp){
        int i=low;
        int j=mid+1;
        int k=low;
        while(i<=mid && j<=high){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }
            else temp[k++]=nums[j++];
        }
        while(i<=mid) temp[k++]=nums[i++];
        while(j<=high) temp[k++]=nums[j++];
        for(int ind=low;ind<=high;ind++) nums[ind]=temp[ind];
    }
}


