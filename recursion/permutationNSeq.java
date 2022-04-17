class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        String ans="";
        List<Integer> nums = new ArrayList<Integer>();
        for(int i=1;i<n;i++){
            fact=fact*i;
            nums.add(i);
        }
        nums.add(n);
        k--;
        while(true){
            ans = ans+String.valueOf(nums.get(k/fact));
            nums.remove(k/fact);
            if(nums.size()==0) break;
            k=k%fact;
            fact = fact/nums.size();
        }
        return ans;
    }
}