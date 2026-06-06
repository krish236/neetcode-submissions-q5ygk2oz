class Pair{
    int first;
    int second;
    int distance;

    Pair(int first, int second, int distance){
        this.first = first;
        this.second = second;
        this.distance = distance;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair>pq = new PriorityQueue<>((Pair p, Pair q)->q.distance-p.distance);
        int n = points.length;

        for(int i = 0; i<n; i++){
                int distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];

                Pair p = new Pair(points[i][0], points[i][1], distance);

                pq.add(p);

                if(pq.size()>k){
                    pq.poll();
                }
            
        }

        int [][]res = new int[k][2];
        int ind = 0;
        while(pq.isEmpty()==false){
            Pair p = pq.poll();

            res[ind][0] = p.first;
            res[ind][1] = p.second;
            ind++;
        }

        return res;
    }
}
