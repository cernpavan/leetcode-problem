class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int [] c = new int [A.length];
        int [] arr = new int [A.length+1];
        int cnt = 0;

        for(int i=0; i<A.length; i++) {
            arr[A[i]]++;
            if(arr[A[i]] == 2)cnt++;
            arr[B[i]]++;
            if(arr[B[i]] == 2)cnt++;
            c[i] = cnt;

        }

        return c;


        
    }
}