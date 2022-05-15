//  brute force approach is finding all subArrays and find the xor all elemenst 
// when xor of all ele's is equals k then inc cnt;
// TC:O(N^2)

// Optimal Appraoch
// find the prefix xor and store it in a hashmap along with its frequency
// when it is repeated then add the freq to cnt(That many times the subArrays with xor is equals to the k);
// TC: O(N) SC:O(N)

import java.util.*;
public class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int sum=0,cnt=0;
        for(int i=0;i<A.length;i++){
            sum^=A[i];
            if(hm.containsKey(sum^B)) cnt+=hm.get(sum^B);
            if(sum==B) cnt++;
             if(hm.containsKey(sum)){
               int a = hm.get(sum);
               hm.put(sum,a+1);
           }else hm.put(sum,1);

        }
        return cnt;
    }
}
