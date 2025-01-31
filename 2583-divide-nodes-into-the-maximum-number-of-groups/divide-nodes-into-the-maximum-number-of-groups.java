class Solution {
    public int magnificentSets(int n, int[][] edges) {
        int rs = 0, n1 = n + 1; // 1-index vertices
        List<List<Integer>> adj = adjGL(edges, n1);
        if (!isBipartite(adj, n1)) return -1; // LC 785

        int degreeBFS[] = new int[n1];
        for (int i = 1; i < n1; i++) degreeBFS[i] = bfsDegree(i, adj);

        int vis[] = new int[n1];
        for (int i = 1; i < n1; i++) if (vis[i] == 0) rs += dfsMaxGroups(i, adj, vis, degreeBFS);

        return rs;
    }

    public static List<List<Integer>> adjGL(int[][] edges, int v) {
        List<List<Integer>> ag = new ArrayList<>();
        for (int i = 0; i < v; i++) ag.add(new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1]; ag.get(a).add(b); ag.get(b).add(a);
        }
        return ag;
    }

    static boolean isBipartite(List<List<Integer>> adj, int v) {
        int color[] = new int[v];
        for (int i = 0; i < v; i++) if (color[i] == 0 && !bfsBipartite(i, adj, color)) return false;
        return true;
    }

    static boolean bfsBipartite(int vertex, List<List<Integer>> adj, int color[]) {
        color[vertex] = 1; // 0: not color, 1: black, 2: red
        Queue<Integer> q = new LinkedList<>(); q.add(vertex);
        while (!q.isEmpty()) {
            int item = q.poll(), vColor = color[item] == 1 ? 2 : 1;
            for (int nVertex : adj.get(item))
                if (color[nVertex] == 0) {
                    color[nVertex] = vColor;
                    q.add(nVertex);
                } else if (color[nVertex] != vColor) return false;
        }
        return true;
    }

    static int bfsDegree(int vertex, List<List<Integer>> adj) {
        Queue<int[]> q = new LinkedList<>(); q.add(new int[]{vertex, 1});
        int item[] = new int[2], vis[] = new int[adj.size()]; vis[vertex] = 1;
        while (!q.isEmpty()) {
            item = q.poll();
            for (int ver : adj.get(item[0]))
                if (vis[ver] == 0) {
                    vis[ver] = 1;
                    q.add(new int[]{ver, item[1] + 1});
                }
        }
        return item[1];
    }

    static int dfsMaxGroups(int vertex, List<List<Integer>> adj, int vis[], int deg[]) {
        vis[vertex] = 1;
        int componentMax = deg[vertex];
        for (int nV : adj.get(vertex))
            if (vis[nV] == 0) componentMax = Math.max(componentMax, dfsMaxGroups(nV, adj, vis, deg));
        return componentMax;
    }
}