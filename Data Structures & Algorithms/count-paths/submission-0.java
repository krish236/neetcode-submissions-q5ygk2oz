class Solution {

    int helper(int ind1, int ind2, int m, int n, int [][]dp){
        if(ind1 == m-1 && ind2 == n-1){
            return 1;
        }
        if(ind1>=m || ind2>=n) return 0;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        int down = helper(ind1+1,ind2,m,n,dp);
        int right = helper(ind1,ind2+1,m,n,dp);

        dp[ind1][ind2] = down+right;
        return dp[ind1][ind2];
    }
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m+1][n+2];

        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,m,n,dp);
    }
}
