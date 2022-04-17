import java.util.*;

public class subSequence {
    public static void main(String[] args){
        int n ;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        List<Integer> l = new ArrayList<Integer>();
        int[] cnt = new int[1];
        generateSubSeq(0,arr,l,cnt);
        System.out.println(cnt[0]);
    }
    public static void generateSubSeq(int ind,int[] arr,List<Integer> l,int[] cnt){
        if(ind>=arr.length){
            // for(Integer ele:l) System.out.print(ele+" ");
            // System.out.println();
            cnt[0]++;
            return;
        }
        l.add(arr[ind]);
        generateSubSeq(ind+1, arr, l,cnt);
        l.remove(l.size()-1);
        generateSubSeq(ind+1, arr, l,cnt);
        return;
    }
}
