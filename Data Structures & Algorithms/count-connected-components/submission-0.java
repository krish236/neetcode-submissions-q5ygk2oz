
// DisJoint set tells in o(1) if 2 nodes are in same component or not 
// we have parent so number where parent == same node thats the answer

class DisJointSet {

    int[] parent;
    int[] size;

    DisJointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findPar(int node) {
        if (node == parent[node])
            return node;

        parent[node] = findPar(parent[node]); // Path compression
        return parent[node];
    }

    void unionBySize(int u, int v) {
        int parU = findPar(u);
        int parV = findPar(v);

        if (parU == parV)
            return;

        if (size[parU] < size[parV]) {
            parent[parU] = parV;
            size[parV] += size[parU];
        } else {
            parent[parV] = parU;
            size[parU] += size[parV];
        }
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {

        int m = edges.length;
        DisJointSet ds = new DisJointSet(n);
        for(int i = 0; i<m; i++){

            int u = edges[i][0];
            int v = edges[i][1];
            ds.unionBySize(u,v);
        }

        int cnt = 0;


        for(int i = 0; i<n; i++){
            if(ds.findPar(i)==i) cnt++;
        }

        return cnt;
    }
}
