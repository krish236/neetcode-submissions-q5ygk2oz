class Solution {

    List<List<String>>ls = new ArrayList<>();

    boolean isValid(char[][]board, int row, int col, int n){
        if(row>n) return false;

        int tr = row;
        int tc = col;

        while(tr>=0){
            if(board[tr][col]=='Q') return false;
            tr--;
        }
        
        while(tc>0){
            if(board[row][tc] == 'Q') return false;
            tc--;
        }
        tr = row;
        tc = col;
        while(tr>=0 && tc<n){
            if(board[tr][tc]=='Q') return false;
            tr--;
            tc++;
        }

        tr = row;
        tc = col;

        while(tr>=0 && tc>=0){
            if(board[tr][tc]=='Q') return false;
            tr--;
            tc--;
        }

        return true;
    }

    void solve(char [][]board, int n, int row){

        if(row == n){
            List<String>res = new ArrayList<>();

            for(int i = 0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<n; j++){
                    sb.append(board[i][j]);
                }
                res.add(sb.toString());
            }

            ls.add(res);
            return;
        }
        for(int col = 0; col<n; col++){
            if(isValid(board,row,col,n)){
                board[row][col] = 'Q';
                solve(board,n,row+1);
                board[row][col] = '.';
            }
        } 

    }
    public List<List<String>> solveNQueens(int n) {
        char [][]board = new char[n][n];

        for(int i = 0; i<n; i++){
            Arrays.fill(board[i],'.');
        }

        solve(board,n,0);

        return ls;
    }
}
