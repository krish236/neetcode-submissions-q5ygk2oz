class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indeg = new int[numCourses];

        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            // v -> u
            adj[v].add(u);
            indeg[u]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ls = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            ls.add(node);

            for (Integer adjNode : adj[node]) {
                indeg[adjNode]--;

                if (indeg[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        return ls.size() == numCourses;
    }
}