class Solution {
    public int parent[], size[];
    public int find(int a) {

        if(parent[a] == a) 
            return a;

        return parent[a] = find(parent[a]);
    }
    public void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB)
            return ;

        if(size[rootA] >= size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        parent = new int[n*n];
        size = new int[n*n];

        int index = 0;
        while(index < n * n) {
            parent[index] = index;

            int row = index / n;
            int col = index % n;
            if(grid[row][col] == 1) {
                size[index] = 1;
            }
            index++;
        }

        int moves[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        int maxIsland = 0;
        index = 0;

        while(index < n * n) {
            int row = index / n;
            int col = index % n;

            if(grid[row][col] == 1) {
                for(int i = 0; i < 4; i++) {
                    int nextRow = moves[i][0] + row;
                    int nextCol = moves[i][1] + col;

                    if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] == 0) 
                        continue;

                    if(i == 0) {
                        union(index, index - n);
                    } else if(i == 1) {
                        union(index, index + 1);
                    } else if(i == 2) {
                        union(index, index + n);
                    } else {
                        union(index, index - 1);
                    }
                }

                maxIsland = Integer.max(maxIsland, size[find(index)]);
            }
            index++;
        }

        index = 0;
        while(index < n * n) {

            int row = index / n;
            int col = index % n;

            if(grid[row][col] == 0) {

                Set<Integer> set = new HashSet<>();
                int currIsland = 1;

                for(int j = 0; j < 4; j++) {

                    int nextRow = row + moves[j][0];
                    int nextCol = col + moves[j][1];

                    if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] == 0) 
                        continue;
                    
                    int rootIndex = -1;
                    if(j == 0) {
                        rootIndex = find(index - n);
                    } else if(j == 1) {
                        rootIndex = find(index + 1);
                    } else if(j == 2) {
                        rootIndex = find(index + n);
                    } else {
                        rootIndex = find(index - 1);
                    }

                    if(!set.contains(rootIndex)) {
                        currIsland += size[rootIndex];
                        set.add(rootIndex);
                    }
                }

                maxIsland = Integer.max(maxIsland, currIsland);
            }
            index++;
        }

        return maxIsland;
    }
}