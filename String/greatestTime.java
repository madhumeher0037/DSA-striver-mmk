import java.util.*;

class Test{
    public static void main(String[] args){
        String s;
        Scanner sc = new Scanner(System.in);
        s=sc.next();
        Set<Integer> s1 = new HashSet<Integer>();
        for(Character c : s.toCharArray()){
            s1.add(c-'0');
        }
        int minutes = Integer.parseInt(s.substring(0,2))*60;
        minutes+=Integer.parseInt(s.substring(3));
        while(true){
            minutes= (minutes+1)%(24*60);
            // below array retrives the first and second num in hours and minutes
            int[] min ={minutes/60/10,minutes/60%10,minutes%60/10,minutes%60%10};
            boolean foundNum=true;
            for(int i=0;i<min.length;i++){
                if(!s1.contains(min[i])) foundNum=false;
            }
            if(foundNum){
                System.out.println(minutes/60 +":"+ minutes%60);
                break;
            }
        }
    }
}