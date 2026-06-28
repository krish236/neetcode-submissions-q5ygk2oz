class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int startRow = 0;
        int startCol = 0;

        int endRow = n-1;
        int endCol = m-1;
        List<Integer>ls = new ArrayList<>();

        int count = 0;
        while(count<n*m){
            
            for(int j = startCol; j<=endCol && count<n*m; j++){
                ls.add(matrix[startRow][j]);
                count++;
            }
            startRow++;
            for(int i = startRow; i<=endRow && count<n*m; i++){
                ls.add(matrix[i][endCol]);
                count++;
            }
            endCol--;

            for(int j = endCol; j>=startCol && count<n*m; j--){
                ls.add(matrix[endRow][j]);
                count++;
            }
            endRow--;
            for(int i = endRow; i>=startRow && count<n*m; i--){
                ls.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }

        return ls;
    }
}
