// Inoder to try all combination we use the pick or not pick technique of recurssion,
// Whenever the candidate element is less than target,we r not pick the element
// then we pick the other elements,if index reaches the last most element 
// then we add inside List to res List.Then we backtrack to Last picked ELement.
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        comSum(0,candidates,target,n,temp,res);
        return res;
    }
    public static void comSum(int index,int[] candidates,int target,int n,List<Integer>temp,List<List<Integer>> res){
        if(index>=n){
            if(target==0){
                List<Integer> newTemp = new ArrayList<Integer>(temp);
                res.add(newTemp);
            }
            return;
        }
        
        if(candidates[index]<=target){ 
            //pick the ELement
            temp.add(candidates[index]);
            comSum(index,candidates,target-candidates[index],n,temp,res);
            // before not picking,first remove the last picked ELement            
            temp.remove(temp.size()-1);
        }
        //not pick the ELement
        comSum(index+1,candidates,target,n,temp,res);
        return;
    }
}