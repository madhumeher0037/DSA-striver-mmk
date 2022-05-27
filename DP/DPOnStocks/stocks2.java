// memoization
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++) Arrays.fill(dp[i],-1);
        return findMaxProfit(0,prices,1,dp);
    }
    
    public int findMaxProfit(int ind,int[] prices,int buy,int[][] dp){
        if(ind==prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit =0;
        if(buy==1){
            profit = Math.max(-prices[ind]+findMaxProfit(ind+1,prices,0,dp),0+findMaxProfit(ind+1,prices,1,dp));
        }
        else{
            profit = Math.max(prices[ind]+findMaxProfit(ind+1,prices,1,dp),0+findMaxProfit(ind+1,prices,0,dp));
        }
        return dp[ind][buy]=profit;
    }
}

//  tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0]=dp[n][1]=0;
        for(int ind =n-1;ind>=0;ind--){
            for(int buy =0;buy<2;buy++){
                if(buy==1){
                    dp[ind][buy] = Math.max(-prices[ind]+dp[ind+1][0],0+dp[ind+1][1]);
                }
                else{
                    dp[ind][buy] = Math.max(prices[ind]+dp[ind+1][1],0+dp[ind+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}