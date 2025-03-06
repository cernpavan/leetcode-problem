class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer,Integer> mpps=new HashMap<>();
        int len=grid.length;
        int repeatedvalue=Integer.MIN_VALUE;
        int gridsum=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(mpps.containsKey(grid[i][j])){
                    repeatedvalue=grid[i][j];
                }
                mpps.put(grid[i][j],mpps.getOrDefault(grid[i][j],0)+1);
                gridsum+=grid[i][j];
            }
        }
        len=len*len;
        int totalsquaresum=(len*(len+1))/2;
        System.out.println(totalsquaresum);
        gridsum-=repeatedvalue;
        int missingvalue=totalsquaresum-gridsum;
        return new int[] {repeatedvalue,missingvalue};
    }
}

// 1,4,9,16

// 2*5*3

// 15*3=30

