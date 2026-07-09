class Solution {

    int dr[] = {-1,0,1,0};
    int dc[] = {0,1,0,-1};
    boolean find(int row, int col, int ind, String target, int[][] vis, char[][]board, int n, int m){
        if(ind >= target.length()) return true;
        vis[row][col] = 1;
        boolean res = false;

        for(int i = 0; i<4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m 
            && target.charAt(ind)==board[nr][nc] && vis[nr][nc]==0){
                res = res || find(nr,nc,ind+1,target,vis,board,n,m);
            }
        }

        vis[row][col] = 0;

        return res;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean res = false;
        int[][] vis = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(word.charAt(0)==board[i][j]){
                    vis[i][j] = 1;
                    res = res || find(i,j,1,word,vis,board,n,m);
                    if(res == true) return true;
                    vis[i][j] = 0;
                }
            }
        }

        return res;
    }
}
