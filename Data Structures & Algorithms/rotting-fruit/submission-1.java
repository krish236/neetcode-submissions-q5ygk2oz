class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {    
    public int orangesRotting(int[][] grid) {
        Queue<Pair>q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;


        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==2){
                    Pair p = new Pair(i,j);
                    q.add(p);
                }
            }
        }
        int timeTaken = -1;

        int []dr = {-1,0,1,0};
        int []dc = {0,1,0,-1};

        while(q.isEmpty()==false){
            int size = q.size();

            for(int i = 0; i<size; i++){
                Pair p = q.poll();
                int row = p.row;
                int col = p.col;

                for(int j= 0; j<4; j++){
                    int nr = row + dr[j];
                    int nc = col + dc[j];

                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                        q.add(new Pair(nr,nc));
                        grid[nr][nc] = 2;
                    }
                }
            }
            timeTaken++;
        }


        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1) return -1;
            }
        }
        if(timeTaken == -1) return 0;
        return timeTaken;
        
    }
}
