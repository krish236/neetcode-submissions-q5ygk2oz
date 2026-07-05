class Solution {

    boolean helper(int []nums, int target, int ind, int [][]dp){
        if(ind == nums.length-1)
        {
            return nums[ind]==target;
        }
        if(target==0) return true;
        if(dp[ind][target]!=-1) return dp[ind][target]==0?false:true;
        boolean notPick = helper(nums,target,ind+1,dp);

        boolean pick = false;

        if(nums[ind]<=target){
            pick = helper(nums,target-nums[ind],ind+1,dp);
        }
        boolean res = pick || notPick;

        dp[ind][target] = res==true?1:0;
        return res;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum =  0;
        
        for(int num : nums){
            totSum+=num;
        }
        if(totSum%2!=0) return false;


        int [][]dp = new int[n][(totSum/2)+1];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,totSum/2,0,dp);
    }
}
