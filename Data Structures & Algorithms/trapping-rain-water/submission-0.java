class Solution {
    public int trap(int[] nums) {
        int n = nums.length;

        int leftMax = 0;
        int rightMax = 0;

        int i = 0;
        int j = n-1;
        int waterStored = 0;
        while(i<=j){
            if(leftMax <rightMax){
                if(nums[i]<leftMax){
                    waterStored += leftMax-nums[i];
                }else{
                    leftMax = nums[i];
                }
                i++;
            }else{
                if(nums[j]<rightMax){
                    waterStored += rightMax-nums[j];
                }
                else{
                    rightMax = nums[j];
                }
                j--;
            }
        }
        return waterStored;
    }
}
