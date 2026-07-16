class Solution {
    int dr[] = {-1,0,1,0};
    int dc[] = {0,1,0,-1};
    int helper(int [][] matrix, int row, int col, int n, int m, int [][]dp){
        
        int maxi = 1;

        if(dp[row][col]!=-1) return dp[row][col];
        for(int i = 0; i<4; i++){
            int nr = row+dr[i];
            int nc = col+dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && matrix[nr][nc]>matrix[row][col]){
                maxi = Math.max(maxi,1+helper(matrix,nr,nc,n,m,dp));
            }
        }

        dp[row][col] = maxi;

        return maxi;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int [][]dp = new int[n][m];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, helper(matrix, i, j, n, m,dp));
            }
        }

        return ans;
        
    }
}
