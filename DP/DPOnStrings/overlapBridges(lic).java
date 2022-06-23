import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int[][] order = new int[n][2];
        for(int i=0;i<n;i++){
            order[i][0]=sc.nextInt();
            order[i][1]=sc.nextInt();
        }
        Arrays.sort(order,(o1,o2)->{
                if(o1[0]!=o2[0]) return o1[0]-o2[0];
                else return o1[1]-o2[1];
            });
        int[] south = new int[n];
        for(int i=0;i<n;i++) south[i]=order[i][1];
        int res = longestIncreasingSubsequence(south);
        System.out.println(res);
        return;
    }
    public static int longestIncreasingSubsequence(int arr[]) {
		    //Your code goes here
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp,1);
		int maxLicLen=1;
		for(int curri=0;curri<n;curri++){
			for(int previ=0;previ<curri;previ++){
				if(arr[previ]<arr[curri]){
					dp[curri]=Math.max(dp[curri],dp[previ]+1);
				}
			}
			maxLicLen = Math.max(dp[curri],maxLicLen);
		} 
		return maxLicLen;
    }

}