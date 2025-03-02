import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> mpps = new TreeMap<>(); 

        for (int[] num : nums1) {
            mpps.put(num[0], mpps.getOrDefault(num[0], 0) + num[1]);
        }

      
        for (int[] num : nums2) {
            mpps.put(num[0], mpps.getOrDefault(num[0], 0) + num[1]);
        }

      
        int[][] res = new int[mpps.size()][2];
        int r = 0;
        for (Map.Entry<Integer, Integer> entry : mpps.entrySet()) {
            res[r][0] = entry.getKey();
            res[r][1] = entry.getValue();
            r++;
        }

        return res;
    }
}
