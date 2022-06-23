class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        PriorityQueue<Character> l1 = new PriorityQueue<Character>();
        PriorityQueue<Character> l2 = new PriorityQueue<Character>();
        for(int i=0;i<s.length();i++) l1.add(s.charAt(i));
        for(int i=0;i<t.length();i++) l2.add(t.charAt(i));
        for(int i=0;i<t.length();i++) if(l1.poll()!=l2.poll()) return false;
        return true;
    }
}