class Solution {

    int[] nseHelper(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = n - 1;
            } else {
                nse[i] = st.peek() - 1;
            }

            st.push(i);
        }

        return nse;
    }

    int[] pseHelper(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                pse[i] = 0;
            } else {
                pse[i] = st.peek() + 1;
            }

            st.push(i);
        }

        return pse;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = nseHelper(heights);
        int[] pse = pseHelper(heights);

        int area = 0;
        for (int i = 0; i < n; i++) {
            area = Math.max(area, heights[i] * (nse[i] - pse[i] + 1));
        }

        return area;
    }
}