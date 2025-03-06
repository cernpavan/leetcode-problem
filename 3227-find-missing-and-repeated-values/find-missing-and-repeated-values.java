class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int repeatedValue = -1;
        int missingElement = -1;

        // Step 1: Find the repeated value by marking visited numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(grid[i][j]); // Get absolute value (original number)

                int row = (val - 1) / n;  // Convert value to row index
                int col = (val - 1) % n;  // Convert value to column index

                // If already negative, it means this number was seen before
                if (grid[row][col] < 0) {
                    repeatedValue = val;
                } else {
                    grid[row][col] = -grid[row][col]; // Mark as visited by negating
                }
            }
        }

        // Step 2: Find the missing number (the one that is still positive)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) { // The missing number's position remains positive
                    missingElement = (i * n) + (j + 1);
                    break;
                }
            }
        }

        return new int[]{repeatedValue, missingElement};
    }
}


//   9,1,7
//   8,9,2
//   3,4,6

// HashMap<Integer,Integer> mpps=new HashMap<>();
//         int len=grid.length;
//         int repeatedvalue=Integer.MIN_VALUE;
//         int gridsum=0;
//         for(int i=0;i<len;i++){
//             for(int j=0;j<len;j++){
//                 if(mpps.containsKey(grid[i][j])){
//                     repeatedvalue=grid[i][j];
//                 }
//                 mpps.put(grid[i][j],mpps.getOrDefault(grid[i][j],0)+1);
//                 gridsum+=grid[i][j];
//             }
//         }
//         len=len*len;
//         int totalsquaresum=(len*(len+1))/2;
//         System.out.println(totalsquaresum);
//         gridsum-=repeatedvalue;
//         int missingvalue=totalsquaresum-gridsum;
//         return new int[] {repeatedvalue,missingvalue};
// // 1,4,9,16

// 2*5*3

// 15*3=30

