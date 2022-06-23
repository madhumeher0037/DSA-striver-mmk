class Solution {
    public int minCost(int n, int[] cuts) {
        int[] c = new int[cuts.length+2];
        c[0]=0;
        c[c.length-1]=n;
        for(int i=1;i<c.length-1;i++) c[i]=cuts[i-1];
        Arrays.sort(c);
        // System.out.println(Arrays.toString(c));
        int[][] dp = new int[c.length+1][c.length+1];
        for(int i=0;i<=c.length;i++) Arrays.fill(dp[i],-1);
        return findMinCost(1,cuts.length,c,dp);
    }
    public static int findMinCost(int low,int high,int[] cuts,int[][] dp){
        if(low>high ) return 0;
        if(dp[low][high]!=-1) return dp[low][high];
        int min = Integer.MAX_VALUE;
        for(int i=low;i<=high;i++){
            int ans = cuts[high+1]-cuts[low-1]+findMinCost(low,i-1,cuts,dp)+findMinCost(i+1,high,cuts,dp);
            min= Math.min(min,ans);
        }
        return dp[low][high]=min;
    }
}public class minCostToCutStick {
    
}
