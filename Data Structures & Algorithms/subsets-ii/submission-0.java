class Solution {

    void solve(int[] nums, int ind, List<Integer>ls, List<List<Integer>>res){
        res.add(new ArrayList<>(ls));

        for(int i = ind; i<nums.length; i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;

            ls.add(nums[i]);
            solve(nums,i+1,ls,res);
            ls.remove(ls.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>ls = new ArrayList<>();
        solve(nums,0,ls,res);
        return res;
    }
}
