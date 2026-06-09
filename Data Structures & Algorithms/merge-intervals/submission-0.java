class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(int[] a, int[] b)->a[0]-b[0]);
        List<int[]>ls = new ArrayList<>();
        int []tmp = intervals[0];
        for(int []interval : intervals){
            if(tmp[1]>=interval[0]){
                tmp[0] = Math.min(tmp[0],interval[0]);
                tmp[1] = Math.max(tmp[1],interval[1]);
            }
            else{
                ls.add(tmp.clone());
                tmp = interval;
            }
        }

        ls.add(tmp);

        return ls.toArray(new int[0][]);
    }
}
