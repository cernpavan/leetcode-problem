class Solution {
    public int[] applyOperations(int[] nums) {
        int len = nums.length;

        // Step 1: Merge adjacent equal elements
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Move all zeros to the end while maintaining order
        int i = 0; // Position to place the next non-zero element
        for (int j = 0; j < len; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        return nums;
    }
}
