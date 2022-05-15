class Solution {
    public int myAtoi(String s) {
        long res=1;
        StringBuilder str = new StringBuilder(s);
        str = removeTrailingSpaces(str);
        if(str.length()>0){
            if(str.charAt(0)=='-') res*=-1;
            else if(str.charAt(0)=='+') str.delete(0,1);
            if(res<0) str.delete(0,1);
        }
        long val = 0;
        String r="";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) r+=str.charAt(i);
            else break;
            val = Long.parseLong(r);
            if(val*res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(val*res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        res*=val;
        return (int)res;
    }
    public static StringBuilder removeTrailingSpaces(StringBuilder s){
        int i=0;
        while(i<s.length() && s.charAt(i)==' ') s.delete(i,i+1);
        return s;
    }
    
}