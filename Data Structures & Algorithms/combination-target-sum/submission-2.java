class Solution {

    void backTrack(int[] nums, int target, List<Integer>tmp, List<List<Integer>>ls, int ind){
        if(target==0){
            ls.add(new ArrayList<>(tmp));
            return;
        }
        if(ind == nums.length || target<0){
            return;
        }
        
        if(target>=nums[ind]){
            tmp.add(nums[ind]);
            backTrack(nums,target-nums[ind],tmp,ls,ind);
            tmp.remove(tmp.size()-1);
            
        }

        backTrack(nums,target,tmp,ls,ind+1);
        
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>ls = new ArrayList<>();
        backTrack(nums,target,ls,res,0);

        return res;

    }
}
