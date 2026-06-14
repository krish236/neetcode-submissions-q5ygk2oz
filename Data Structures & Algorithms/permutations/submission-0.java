class Solution {
    void swap(int []nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    void helper(int []nums, List<List<Integer>>res, int ind, int n){
        if(ind == n){
            List<Integer>ls = new ArrayList<>();

            for(int num : nums)
                ls.add(num);

            res.add(ls);
            return;
        }

        for(int i = ind; i<n; i++){
            swap(nums,i,ind);
            helper(nums,res,ind+1,n);
            swap(nums,i,ind);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>>res = new ArrayList<>();
        helper(nums,res,0,n);
        return res;
    }
}
