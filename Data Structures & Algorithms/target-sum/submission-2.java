// A - (sum-A) = t
// A = (t+sum)/2
class Solution {

    int helper(int[] nums, int target, int ind, int n, int[][] dp){

        if(ind == n){
            return target == 0 ? 1 : 0;
        }

        if(dp[ind][target] != -1)
            return dp[ind][target];

        int pick = 0;

        if(nums[ind] <= target)
            pick = helper(nums, target - nums[ind], ind + 1, n, dp);

        int notPick = helper(nums, target, ind + 1, n, dp);

    return dp[ind][target] = pick + notPick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totSum = 0;

        for(int i = 0; i<n; i++){
            totSum += nums[i];
        }
        
        int newTarget = (target+totSum)/2;
        int dp[][] = new int[n][newTarget+1];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }

        if((target + totSum) % 2 != 0) return 0;
        return helper(nums,newTarget,0,n,dp);
    }
}
