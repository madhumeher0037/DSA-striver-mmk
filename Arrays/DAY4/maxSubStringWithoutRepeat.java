// best approach using the hashmap stores the prev index
// when any character is repeated and it is in range of left and right 
// then left pointer jumos to next possible character
// TC:O(n) SC:o(n);
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen =0;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        int r=0,l=0;
        while(l<s.length() && r<s.length()){
            if(hm.containsKey(s.charAt(r))){
                int ind = hm.get(s.charAt(r));
                if(ind>=l && ind<=r) l=ind+1;
            }
            hm.put(s.charAt(r),r);
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}
// Sliding window approach
//  TC:O(2N) worst case SC:O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen =0;
        Set<Character> hs = new HashSet<Character>();
        int r=0,l=0;
        while(l<s.length() && r<s.length()){
            while(r<s.length()){
                if(!hs.contains(s.charAt(r))){
                    hs.add(s.charAt(r));
                    maxLen = Math.max(maxLen,r-l+1);
                    r++;
                }
                else{
                    hs.remove(s.charAt(l));
                    l++;
                }
            }
        }
        return maxLen;
    }
}

// brute force
// TC:O(N^2) SC:O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen =0;
        for(int i=0;i<s.length();i++){
            List<Character> l = new ArrayList<Character>();
            int j=i;
            for(;j<s.length();j++){
                if(l.contains(s.charAt(j))) break;
                l.add(s.charAt(j));
            }
            maxLen=Math.max(maxLen,j-i);
            // System.out.println(l);
            // System.out.println(maxLen);
        }
        return maxLen;
    }
}