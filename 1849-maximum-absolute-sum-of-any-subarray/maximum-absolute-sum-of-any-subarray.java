class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        // Max SubArray Sum - Kadane's Algo
        int max = Integer.MIN_VALUE;
        int currMax = 0;

        for(int i=0; i<n; i++){
            currMax += nums[i];

            if(currMax > max) max = currMax;

            if(currMax < 0) currMax = 0;
        }

        // Min SubArray Sum - Reversed Kadane's Algo
        int min = Integer.MAX_VALUE;
        int currMin = 0;

        for(int i=0; i<n; i++){
            currMin += nums[i];

            if(currMin < min) min = currMin;

            if(currMin > 0) currMin = 0;
        }

        return Math.max(max, Math.abs(min));
    }
}