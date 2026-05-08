class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);


        for(int i = 0; i<n; i++){
            pq.add(stones[i]);
        }

        while(pq.size()>1){
            int first = pq.poll();
            
            int second = pq.poll();

            if(first>second){
                pq.add(first-second);
            }else{
                pq.add(second-first);
            }
        }

        return pq.size()==0?0:pq.peek();
    }
}
