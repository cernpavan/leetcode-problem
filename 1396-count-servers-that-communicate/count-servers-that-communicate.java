class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        // Arrays to count the number of servers in each row and column
        int[] rowCount = new int[rows];
        int[] colCount = new int[columns];

        // Count servers in each row and column
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Count servers that can communicate with others
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}