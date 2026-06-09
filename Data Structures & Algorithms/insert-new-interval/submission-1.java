class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();
        boolean inserted = false;

        for (int[] interval : intervals) {

            // interval completely before newInterval
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            }

            // interval completely after newInterval
            else if (interval[0] > newInterval[1]) {

                if (!inserted) {
                    res.add(new int[]{newInterval[0], newInterval[1]});
                    inserted = true;
                }

                res.add(interval);
            }

            // overlap
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (!inserted) {
            res.add(new int[]{newInterval[0], newInterval[1]});
        }

        return res.toArray(new int[res.size()][]);
    }
}