class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for(int i = 0; i<n; i++){
            sum+=nums[i];
        }

        int tot = 0;

        for(int j = 0; j<=n; j++){
            tot+=j;
        }

        return tot-sum;
    }
}
