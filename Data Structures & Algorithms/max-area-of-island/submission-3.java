class Solution {
    int []dr = {-1,0,1,0};
    int []dc = {0,+1,0,-1};

    int maxi = 0;
    int dfs(int[][] grid, int[][] vis, int row, int col, int n, int m){
        vis[row][col] = 1;
        int cnt = 1;
        for(int i = 0; i<4; i++){

            int nr = row + dr[i];
            int nc = col + dc[i];
            
            if(nr<n && nr>=0 && nc<m && nc>=0 && grid[nr][nc]==1 &&
            vis[nr][nc]==0){
                
                cnt+=dfs(grid,vis,nr,nc,n,m);
            }
        }   
        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                vis[i][j] = 0;
            }
        }
        int cnt = 0;
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    
                    maxi = Math.max(maxi,dfs(grid,vis,i,j,n,m));
                }
            }
        }

        return maxi;
    }
}
