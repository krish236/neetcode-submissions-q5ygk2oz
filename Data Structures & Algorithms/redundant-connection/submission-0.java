class DisJointSet{
    int []parent;
    int []size;

    DisJointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int node){
        if(parent[node]==node) return node;
        return parent[node] = findUPar(parent[node]);
    }

    void unionBySize(int u, int v){
        int p_u = findUPar(u);
        int p_v = findUPar(v);

        if(p_u == p_v) return;

        int size_u = size[p_u];
        int size_v = size[p_v];

        if(size_u>size_v){
            size[u]+= size_v;

            parent[p_v] = p_u;
        }else{
            size[v]+=size_u;
            parent[p_u] = p_v;
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        DisJointSet ds = new DisJointSet(n);
        int []arr = new int[2];
        for(int i = 0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(ds.findUPar(u)==ds.findUPar(v)) {
                arr[0] = u;
                arr[1] = v;

                return arr;
            }
            ds.unionBySize(u,v);
        }

        return arr;
    }
}
