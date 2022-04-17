/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
        int n,sum=0;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        sum = sc.nextInt();
        List<Integer> l = new ArrayList<Integer>();
        System.out.println(checkForSubSeq(0,arr,sum,l,0));
        return;
	}
	public static int checkForSubSeq(int ind,int[] arr,int sum,List<Integer> l,int s){
	    if(ind>=arr.length){
	        if(s==sum) return 1;
	        return 0;
	    }
	    int x=0;
	   // pick
	    l.add(arr[ind]);
	    s+=arr[ind];
	    int left =checkForSubSeq(ind+1,arr,sum,l,s);
	   // NotPick
	    l.remove(l.size()-1);
	    s-=arr[ind];
	    int right=checkForSubSeq(ind+1,arr,sum,l,s);
	    
	    return left+right;
	}
}
