class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int step = 0;
        int farthest = 0;
        for(int i = 0; i<n; i++){

            if(i==n-1) return step;
            maxi = Math.max(maxi,nums[i]+i);

            if(i==farthest && maxi>farthest){
                farthest = Math.max(farthest,maxi);
                step++;
            }
        }
        return -1;
    }
}
