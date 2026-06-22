class Solution {

    int solve(int []prices, int ind, int n, int buy, int [][]dp){
        if(ind >= n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit = 0;
        if(buy==0){
            profit = Math.max(-prices[ind] + solve(prices,ind+1,n,1,dp), solve(prices,ind+1,n,0,dp));
        }

        else if(buy==1){
            profit = Math.max(prices[ind]+solve(prices,ind+2,n,0,dp),solve(prices,ind+1,n,buy,dp));
        }

        dp[ind][buy] = profit;
        return dp[ind][buy];


    }
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int [][]dp = new int[n][2];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(prices,0,n,0,dp);
    }
}
