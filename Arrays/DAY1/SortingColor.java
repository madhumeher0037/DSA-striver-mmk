class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for(int i=0;i<nums.length;i++) freq[nums[i]]++;
        int i=0,j=0;
        while(i<nums.length){
            while(freq[j]!=0){
                nums[i]=j;
                i++;
                freq[j]--;
            }
            j++;
        }
    }
}