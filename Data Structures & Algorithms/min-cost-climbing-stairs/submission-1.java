class Solution {

    int helper(int[] cost, int ind, int[]dp){
        if(ind >= cost.length) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int oneStep = cost[ind]+ helper(cost,ind+1,dp);
        int twoStep = cost[ind]+ helper(cost,ind+2,dp);

        dp[ind] = Math.min(oneStep,twoStep);
        return dp[ind];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[]dp = new int[n];

        Arrays.fill(dp,-1);
        return Math.min(helper(cost,0,dp), helper(cost,1,dp));
    }
}
