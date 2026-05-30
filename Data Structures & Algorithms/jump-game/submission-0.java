class Solution {
    public boolean canJump(int[] nums) {
        int maxiJump = nums[0];
        int n = nums.length;
        for(int i = 1; i<n; i++){
            if(i<=maxiJump){
                maxiJump = Math.max(maxiJump,i+nums[i]);
            }
        }

        return maxiJump>=n-1;
    }
}
