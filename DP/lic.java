import java.util.*;

class Test{
    public static void main(String[] args){
        String s;
        Scanner sc = new Scanner(System.in);
        s=sc.nextLine();
        String[] str = s.split(" ");
        List<Integer> l = new ArrayList<Integer>();
        int[] lis = new int[str.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<str.length;i++){
            l.add(Integer.parseInt(str[i]));
            lis[i]=1;
        }
        for(int i=0;i<l.size();i++){
            for(int j=i+1;j<l.size();j++){
                if(l.get(j)>l.get(i)){
                    if(lis[j]<=lis[i]){
                        lis[j]=1+lis[i];
                        max=Math.max(max,lis[j]);
                    }
                }
            }
        }
        System.out.println(max);
        return;
    }
}