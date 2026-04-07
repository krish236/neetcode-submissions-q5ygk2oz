class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer,Integer>mp = new HashMap<>();
        int [] a = new int[2];
        for(int i = 0; i<n; i++){
            if(mp.containsKey(target-nums[i])==true){
                a[0] = mp.get(target-nums[i]);
                a[1] = i;
                return a;
            }

            mp.put(nums[i],i);
        }

        return a;
    }
}
