class Solution {

    boolean isValid(char[][] board, int row, int col){
        char ch = board[row][col];

        for(int i = 0; i < 9; i++){

            // row check
            if(i != col && board[row][i] == ch) return false;

            // column check
            if(i != row && board[i][col] == ch) return false;

            // subgrid check
            int r = 3*(row/3) + i/3;
            int c = 3*(col/3) + i%3;

            if((r != row || c != col) && board[r][c] == ch)
                return false;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!isValid(board, i, j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}