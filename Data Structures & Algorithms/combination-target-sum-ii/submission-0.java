class Solution {
    void helper(int ind, int []candidates, int target, List<Integer>ls, List<List<Integer>>res, int n){

        if(target==0){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = ind; i<n; i++){

            if(i>ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]<=target){
                ls.add(candidates[i]);
                helper(i+1,candidates,target-candidates[i],ls,res,n);
                ls.remove(ls.size()-1);
            }
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>ls = new ArrayList<>();
        int n = candidates.length;
        helper(0,candidates,target,ls,res,n);
        return res;
        
    }
}
