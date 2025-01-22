import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        
        // Directions for moving up, right, down, and left
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // Queue for BFS
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[rows][cols];

        // Initialize water cells with height 0 and add them to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    res[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    res[i][j] = -1; // Mark land cells as unvisited
                }
            }
        }

        // BFS to assign heights
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            // Explore all 4 directions
            for (int[] d : dir) {
                int newR = r + d[0];
                int newC = c + d[1];

                // Check bounds and if the cell has not been visited
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && res[newR][newC] == -1) {
                    res[newR][newC] = res[r][c] + 1; // Assign height
                    q.offer(new int[]{newR, newC}); // Add new cell to the queue
                }
            }
        }

        return res;
    }
}