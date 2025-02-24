class Solution {
    private int max = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] it : edges) {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        int[] time = new int[n];
        Arrays.fill(time, -1);
        bobsy(adj, bob, time, 0);
        getMax(adj, 0, amount, time, 0, 0);
        return max;
    }

    private void getMax(List<List<Integer>> adj, int node, int[] amount, int[] time, int sum, int currTime) {
        if (time[node] == currTime) {
            sum += amount[node] / 2;
        } else if (time[node] == -1 || time[node] > currTime)
            sum += amount[node];
        if (node != 0 && adj.get(node).size() == 1) {
            max = Math.max(max, sum);
        }
        amount[node] = (int) 1e9;
        for (int it : adj.get(node)) {
            if (amount[it] != (int) 1e9) {
                getMax(adj, it, amount, time, sum, currTime + 1);
            }
        }
    }

    private boolean bobsy(List<List<Integer>> adj, int node, int[] time, int currTime) {
        time[node] = currTime;
        if (node == 0)
            return true;
        for (int it : adj.get(node)) {
            if (time[it] == -1) {
                if (bobsy(adj, it, time, currTime + 1))
                    return true;
            }
        }
        time[node] = -1;
        return false;
    }
}