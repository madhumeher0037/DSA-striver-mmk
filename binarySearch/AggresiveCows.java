import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n,c;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		c=sc.nextInt();
		int[] stalls = new int[n];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) stalls[i]=sc.nextInt();
		Arrays.sort(stalls);
		int low=1,high=stalls[stalls.length-1]-stalls[0],res=Integer.MIN_VALUE;
		while(low<=high){
			int mid = (low+high)/2;
			if(isPossible(stalls,mid,c)){
				res=Math.max(mid,res);
				low=mid+1;
			}
			else high=mid-1;
		}
		System.out.println(res);
	}
	public static boolean isPossible(int[] stalls,int mid,int c){
		int noOfCows=1,lastCowPlaced=stalls[0];
		for(int i=1;i<stalls.length;i++){
			if(stalls[i]-lastCowPlaced>=mid){
				noOfCows++;
				lastCowPlaced=stalls[i];
			}
		}
		return noOfCows>=c;
	}
}