class Solution {
    public int majorityElement(int[] nums) {
        int tar = nums.length/2;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int freq = hm.getOrDefault(nums[i],0);
            if(freq+1>tar) return nums[i];
            hm.put(nums[i],freq+1);
        }
        return -1;
    }
}
// moores voting alogorithm
// The algorithm in it basic sense finds a majority element, if it exists. Majority element is an element that occurs repeatedly for more than half of the input elements. However, if there is no majority, the algorithm will not detect that fact, and will still output one of the elements.

// Basically the algorithm works in two part. First pass finds an element as majority element and a second pass is used to verify that the element found in the first pass is really a majority.

// If the majority element does not exists, the algorithm will not detect that and thus return an arbitrary element.

// So as per the above discussion we have two parts of the discussion:

// First pass: Finds the element which could be a majority element.
// Second pass: check the element's count which is found in the first pass is greater than n/2.


class Solution {
    public int majorityElement(int[] nums) {
        int num=0,cnt=0;
//      Moore’s Voting Algorithm
//      we know that there exit a ele which appers is more than the nums.length/2.
//      so every minority ele will satiesfy the one ele in majority.
//      At the end,only one ele will appears in num which appears more than nums.length/2 times.
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                num=nums[i];
            }
            
            if(nums[i]==num) cnt++;
            else cnt--;
        }
        
        return num;
    }
}