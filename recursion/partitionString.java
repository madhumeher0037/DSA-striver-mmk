class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> innerRes = new ArrayList<String>();
        partString(0,s,innerRes,res);
        return res;
    }
    public void partString(int ind,String s,List<String> innerRes,List<List<String>> res){
        if(ind>=s.length()){
            res.add(new ArrayList<String>(innerRes));
            return;
        }
        
        for(int i = ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                innerRes.add(s.substring(ind,i+1));
                partString(i+1,s,innerRes,res);
                innerRes.remove(innerRes.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}