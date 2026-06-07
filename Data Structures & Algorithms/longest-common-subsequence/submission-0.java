class Solution {

    int helper(String s1, String s2, int ind1, int ind2, int n, int m, int[][] dp){
        if(ind1==n || ind2==m) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return 1 + helper(s1,s2,ind1+1,ind2+1,n,m,dp);
        }

        dp[ind1][ind2] =  Math.max(helper(s1,s2,ind1+1,ind2,n,m,dp),helper(s1,s2,ind1,ind2+1,n,m,dp));

        return dp[ind1][ind2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][]dp = new int[n][m];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(text1,text2,0,0,n,m,dp);
    }
}
