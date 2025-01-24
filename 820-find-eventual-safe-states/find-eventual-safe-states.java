class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        /* 
            State 0 -> Unvisited
            State 1 -> Visited
            State 2 -> Safe
            Note : Can be simulated using 2 sets but this is faster.
        */
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                result.add(i);
            }
        }

        return result;
    }

    public boolean dfs(int src, int[][] graph, int[] state) {
        if (state[src] != 0) {
            return state[src] == 2;
        }

        state[src] = 1;
        for (int neighbor : graph[src]) {
            if (!dfs(neighbor, graph, state)) {
                return false;
            }
        }

        state[src] = 2;
        return true;
    }
}