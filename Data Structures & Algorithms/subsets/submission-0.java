class Solution {

    void helper(int ind, int []nums, List<List<Integer>>ls, List<Integer>res,int n){
        ls.add(new ArrayList<>(res));
        for(int i = ind; i<n; i++){
            res.add(nums[i]);
            helper(i+1,nums,ls,res,n);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>>ls = new ArrayList<>();
        List<Integer>res = new ArrayList<>();
        helper(0,nums,ls,res,n);

        return ls;
    }
}
