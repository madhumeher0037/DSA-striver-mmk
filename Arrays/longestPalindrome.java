import java.util.*;

class Test{
    public static void main(String[] args){
        String s;
        Scanner sc = new Scanner(System.in);
        s=sc.next();
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        boolean flag = false;
        int size=0;
        for(Integer i:hm.values()){
            if(i%2==0) size+=i;
            else{
                if(!flag){
                    size+=i;
                    flag = true;
                }
                else size+=i-1;
            }
        }
        System.out.println(size);
    }
}