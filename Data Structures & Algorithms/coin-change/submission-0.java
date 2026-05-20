class Solution {

    int helper(int []coins, int amount, int ind, int n, int[][]dp){
        if(ind == n-1){
            if(amount%coins[ind]==0) return amount/coins[ind];
            return (int)1e9;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        
        int notPick = helper(coins,amount,ind+1,n,dp);

        int pick = (int)1e9;

        if(coins[ind]<=amount){
            pick = 1+helper(coins,amount-coins[ind],ind,n,dp);
        }

        dp[ind][amount] = Math.min(pick,notPick);

        return dp[ind][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;


        int [][]dp = new int[n][amount+1];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        int res = helper(coins,amount,0,n,dp);
        


        if(res>=(int)1e9) return -1;
        return res;
    }
}
