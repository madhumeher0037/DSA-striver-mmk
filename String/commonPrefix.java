class Solution {
    public String longestCommonPrefix(String[] strs) {
        int ls =-1;
        int maxLen=0;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()>maxLen){
                maxLen=strs[i].length();
                ls=i;
            }
        }
        if(maxLen==0) return "";
        
        int ind =0;
        String res="";
        while(ind<maxLen){
            char ch = strs[ls].charAt(ind);
            boolean isThere = true;
            
            for(int i=0;i<strs.length;i++){
                if(i==ls) continue;
                if(strs[i].length()<ind+1 || strs[i].charAt(ind)!=ch){
                    isThere=false;
                    break;
                }
            }
            if(!isThere) break;
            res+=ch;
            ind++;
        }
        return res;
    }
}