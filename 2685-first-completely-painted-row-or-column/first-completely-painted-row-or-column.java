class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
       HashMap<Integer, int[]> mpps = new HashMap<>();
int rowlen = mat.length;
int collen = mat[0].length;

for (int i = 0; i < rowlen; i++) {
    for (int j = 0; j < collen; j++) {
        mpps.put(mat[i][j], new int[]{i, j});
    }
}

int arrlen = arr.length;
int[] rowcount = new int[rowlen];
int[] colcount = new int[collen];

for (int i = 0; i < arrlen; i++) {
    int[] temp = mpps.get(arr[i]);
    int rind = temp[0];
    int cind = temp[1];
    rowcount[rind]++;
    colcount[cind]++;
    if (rowcount[rind] == collen || colcount[cind] == rowlen) {
        return i;
    }
}

return -1;

    }
    // public static boolean find(int[][] arr,int rind,int cind,int rowlen,int collen){
    //     int sum=0;
    //     for(int i=0;i<collen;i++){
    //         sum+=arr[rind][i];
    //     }
    //     if(sum==0){
    //         return true;
    //     }
    //     sum=0;

    //     for(int i=0;i<rowlen;i++){
    //         sum+=arr[i][cind];
    //     }

    //     if(sum==0){
    //         return true;
    //     }
    //     return false;
    // }
}