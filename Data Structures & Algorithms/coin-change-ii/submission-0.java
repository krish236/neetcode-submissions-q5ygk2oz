class Solution {

    int helper(int ind, int amount, int[] coins, int n, int[][] dp){
        if(ind==n){
           if(amount==0) return 1;
           else return 0;
        }
        if(amount == 0) return 1;
        if(amount<0) return 0;
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int pick = 0;

        if(coins[ind]<=amount){
            pick = helper(ind,amount-coins[ind],coins,n,dp);
        }

        int notPick = helper(ind+1,amount,coins,n,dp);
        dp[ind][amount] = notPick + pick;
        return dp[ind][amount];
    }
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int [][]dp = new int[n][amount+1];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,amount,coins,n,dp);
    }
}
