class Solution {

    private int parent[];
    private int rank[];

    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private boolean unionByRank(int x, int y){
        int p1 = find(x);
        int p2 = find(y);

        // if already part of same component
        // means same parent then joining this edge will create a cycle.

        if(p1 == p2){
            return true;
        }

        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
        }
        else if(rank[p1] < rank[p2]){
            parent[p1] = p2;
        }
        else{
            // if ranks are the same
            // p2 under p1
            parent[p2] = p1;
            // increase by 1
            rank[p1] = rank[p1] + 1;
            
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            if(unionByRank(edge[0] - 1, edge[1] - 1)){
                return edge;
            }
        }

        return new int[2];
    }
}