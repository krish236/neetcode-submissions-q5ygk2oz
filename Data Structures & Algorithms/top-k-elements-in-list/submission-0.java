class Pair{
    public int num;
    public int cnt;

    Pair(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>mp = new HashMap<>();
        int []arr = new int[k];
        int n = nums.length;
        PriorityQueue<Pair>pq = new PriorityQueue<>((Pair p, Pair q)->p.cnt-q.cnt);
        for(int i = 0; i<n; i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        for(Integer key : mp.keySet()){
            Pair p = new Pair(key,mp.get(key));
            pq.add(p);
            if(pq.size()>k) pq.remove();
        }
        int ind = 0;
        while(pq.size()>0){
            Pair p  = pq.poll();
            arr[ind] = p.num;
            ind++;
        }
        return arr;
    }
}
