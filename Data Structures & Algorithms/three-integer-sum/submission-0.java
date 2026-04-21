class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int target = 0;
        List<List<Integer>>res = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            while(i>0 && i<n && nums[i]==nums[i-1])i++;
            int j = i+1;
            int k = n-1;

            while(j<k){
                if(nums[i]+nums[j]+nums[k]==target){
                    List<Integer>ls = new ArrayList<>();
                    ls.add((nums[i]));
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    res.add(ls);
                    j++;
                    k--;
                    while(j>0 && j<n && nums[j]==nums[j-1])j++;
                    while(k>=0 && k<n-1 && nums[k]==nums[k+1]) k--;
                }
                else if(nums[i]+nums[j]+nums[k]>target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return res;
    }
}
