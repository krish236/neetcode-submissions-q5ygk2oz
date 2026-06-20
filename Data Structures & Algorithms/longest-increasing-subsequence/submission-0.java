class Solution {

    int helper(int []nums, int ind, int n, int prev, int [][]dp){
        if(ind == n) return 0;
        int pick = 0;

        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        if(prev == -1 || nums[ind]>nums[prev]){
            pick =  1 + helper(nums,ind+1,n,ind,dp);
        }

        int notPick =  helper(nums,ind+1,n,prev,dp);
        dp[ind][prev+1] = Math.max(pick,notPick);
        return dp[ind][prev+1];
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][]dp = new int[n][n+1];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,0,n,-1,dp);
    }
}
