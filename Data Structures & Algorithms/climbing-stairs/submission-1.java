class Solution {

    int helper(int ind, int[]dp){
        if(ind<=0) return 1;

        if(dp[ind]!=-1) return dp[ind];
        int oneStep = helper(ind-1,dp);

        
        int twoStep = 0;
        
        if(ind>=2)
            twoStep = helper(ind-2,dp);
        

        dp[ind] = oneStep+twoStep;
        return oneStep+twoStep; 
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);

    }
}
