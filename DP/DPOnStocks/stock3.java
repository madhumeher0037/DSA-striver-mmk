public class Solution {
    public int maxProfit(int[] prices) {
//         The three changing parameters are ind,flag and cnt,So construct a three dimensional dp to memoize the subproblems. 
        int[][][] dp = new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return findMaxProfit(0,0,0,prices,dp);
    }
//     flag indicates the buy or not buyed.
//     flag=1 => buy
//     flag=0 => notBuy
    public static int findMaxProfit(int ind,int flag,int cnt,int[] arr,int[][][] dp){
        if(ind==arr.length) return 0;
        if(dp[ind][flag][cnt]!=-1) return dp[ind][flag][cnt];
        int profit = 0;
//         if cnt is 2, means we have dont have make any transactions.
        if(cnt==2) return 0;
        else if(flag==1){
            profit = Math.max(arr[ind]+findMaxProfit(ind+1,0,cnt+1,arr,dp),findMaxProfit(ind+1,1,cnt,arr,dp));
        }
        else{
            profit = Math.max(-arr[ind]+findMaxProfit(ind+1,1,cnt,arr,dp),findMaxProfit(ind+1,0,cnt,arr,dp));
        }
        return dp[ind][flag][cnt]=profit;
    }
}
