class Solution {

    int dr[] = {-1,0,1,0};
    int dc[] = {0,1,0,-1};
    void dfs(char [][] board, int row, int col, boolean[][] vis, int n, int m){
        vis[row][col] = true;

        for(int i = 0; i<4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc] == 'O' && vis[nr][nc] == false){
                dfs(board,nr,nc,vis,n,m);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean [][]vis = new boolean[n][m];

        for(int i = 0; i<n; i++){
            Arrays.fill(vis[i],false);
        }

        for(int i = 0; i<n; i++){
            if(board[i][0] == 'O' && vis[i][0]==false){
                dfs(board,i,0,vis,n,m);
            }
            if(board[i][m-1] == 'O' && vis[i][m-1]==false){
                dfs(board,i,m-1,vis,n,m);
            }
        }

        for(int j = 0; j<m; j++){
            if(board[0][j]=='O' && vis[0][j]==false){
                dfs(board,0,j,vis,n,m);
            }

            if(board[n-1][j]=='O' && vis[n-1][j]==false){
                dfs(board,n-1,j,vis,n,m);
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j]=='O' && vis[i][j]==false){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
