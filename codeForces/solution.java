import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ip = new int[t];
        int i=0;
        while(i<t){
            int n = sc.nextInt();
            ip[i] = n;
            i++;
        }
        for(int ind=0;ind<t;ind++) findCF(ip[ind]);
    }
    public static void findCF(int n){
        int h1=-1,h2 = -1;
        int low = 0,high = n;
        while(low<high){
            int mid = (low+high)/2;
            int val = isPossible(mid,n);
            if(val!=-1){
                h1 = mid;
                h2 = val;
                high = mid-1;
            }
            else low+=1;
        }
        int h3 = n-(h1+h2);
        System.out.println(h2+" "+h1+" "+h3);
    }
    public static int isPossible(int m,int n){
        int h1 = m;
        int h2 = m-1;
        while(h2>0){
            int h3 = n-(h1+h2);
            if((h1>0 && h2>0 && h3>0) && (h1>h2) && (h2>h3)) return h2;
            h2--;
        }
        return -1;
    }
}
