class Solution {

    int helper(List<Integer>ls, int ind, int[] dp){
        if(ind>=ls.size()) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int pick = ls.get(ind)+ helper(ls,ind+2,dp);
        int notPick = helper(ls,ind+1,dp);
        System.out.println(pick + " " + notPick);
        dp[ind] = Math.max(pick,notPick);
        return dp[ind];

    }
    public int rob(int[] nums) {

        int n = nums.length;

        if(n==0) return 0;
        if(n==1) return nums[0];
        List<Integer>ls1 = new ArrayList<>();
        List<Integer>ls2 = new ArrayList<>();

        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        for(int i = 0; i<n; i++){
            if(i!=0){
                ls1.add(nums[i]);
            }
            if(i!=n-1){
                ls2.add(nums[i]);
            }
        }

        return Math.max(helper(ls1,0,dp1), helper(ls2,0,dp2));
    }
}
