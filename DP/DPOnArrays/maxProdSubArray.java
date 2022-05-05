// Brute force TC:O(N)
// class Solution {
//     public int maxProduct(int[] nums) {
//         int product =1;
//         int maxP = Integer.MIN_VALUE;
        
//         for(int i=0;i<nums.length;i++){
//             int val =1;
//            for(int j=i;j<nums.length;j++){
//                val=val*nums[j];
//                maxP=Math.max(maxP,val);
//            }
//         }
//         return maxP;
//     }
// }


// Optimal approach TC:O(n) SC:O(1)
// class Solution {
//     public int maxProduct(int[] nums) {
//         int result=Integer.MIN_VALUE;
//         // what if our array size is 1,then we have return the 1st ele         
//         for(int i=0;i<nums.length;i++) result=Math.max(result,nums[i]);
        
//         int maxEle=1,minEle=1;
//         // Intially intialise the max and min with 1
        
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==0){
//                 maxEle=1;
//                 minEle=1;
//                 continue;
//             }
//             int temp = maxEle*nums[i];
//             // find the previous min and max values.Start multiply with all prev min and prev max
//             // take max of product of prev min and curr,prev max and curr,curr
//             // take min of product of prev min and curr,prev max and curr,curr
//             maxEle = Math.max(nums[i],Math.max((maxEle*nums[i]),(minEle*nums[i])));
//             // because the maxEle var is changed used the temp(DP)             
//             minEle = Math.min(nums[i],Math.min(temp,(minEle*nums[i])));
            
//             result=Math.max(result,maxEle);
//         }
//         return result;
//     }
// }