//  first three elements use the three loops and for the last elements use the binary Search method
// before doing the above procedure sort the given list
// TC:O(NLOGN + N^3*LOGN)
// SC:O(M*4) where m is the size of quadruplets

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                for(int k=j+1;k<n-1;k++){
                    int rem = target-(nums[i]+nums[j]+nums[k]);
                    // System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
                    if(binarySearch(k+1,n-1,nums,rem)){
                        List<Integer> innerRes = new ArrayList<Integer>();
                        innerRes.add(nums[i]);
                        innerRes.add(nums[j]);
                        innerRes.add(nums[k]);
                        innerRes.add(rem);
                        if(!res.contains(innerRes)) res.add(new ArrayList<Integer>(innerRes));
                    }
                }
            }
        }
        return res;
    }
    
    public static boolean binarySearch(int low,int high,int[] arr,int target){
        while(low<=high){
            int mid=(low+high)/2;
            
            if(arr[mid]==target) return true;
            
            else if(target>arr[mid]) low=mid+1;
            else if(target<arr[mid]) high=mid-1;
        }
        
        return false;
    }

}


// find the first two elements using the two loops and next two elements using the two pointers
// TC:O(NLOGN + N^3)
// SC:O(M*4)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
		// sort the arr,so that u can you two pointers approach.
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int rem = target-(nums[i]+nums[j]);
				// first find the two elements using the two loops;
                int low = j+1,high = n-1;
				// next two ele can be achieved using the two pointers approach
                while(low<high){
                    int sum = nums[low]+nums[high];
                    if(sum==rem){
                        List<Integer> innerRes = new ArrayList<Integer>();
                        innerRes.add(nums[i]);
                        innerRes.add(nums[j]);
                        innerRes.add(nums[low]);
                        innerRes.add(nums[high]);
                        if(!res.contains(innerRes)) res.add(innerRes);
                        low++;
                        high--;
						// when ele is found ,then add the ele's to list
						// inc low & dec high for more possibilities
                    }
                    else if(sum>rem) high--; //if sum is greater than remaining ele's means then our rem exists right of high ele's
                    else low++; // converse of above statement
                }
            }
        }
        return res;
    }
}