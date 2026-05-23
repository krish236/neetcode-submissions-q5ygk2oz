
class Solution {

    void helper(double[] timeTaken, int[] nge) {

        Stack<Integer> st = new Stack<>();
        int n = timeTaken.length;

        nge[n - 1] = -1;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {

            // remove smaller times
            while (!st.isEmpty() && timeTaken[st.peek()] < timeTaken[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // position, speed
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // sort by position
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);

        double[] timeTaken = new double[n];

        for (int i = 0; i < n; i++) {

            int pos = cars[i][0];
            int spd = cars[i][1];

            timeTaken[i] = (double)(target - pos) / spd;

            System.out.print(timeTaken[i] + " ");
        }

        System.out.println();

        int[] nge = new int[n];

        helper(timeTaken, nge);

        int fleet = 0;

        for (int i = 0; i < n; i++) {

            System.out.println(
                "time = " + timeTaken[i] +
                "  nge = " + nge[i]
            );

            if (nge[i] == -1) {
                fleet++;
            }
        }

        return fleet;
    }
}