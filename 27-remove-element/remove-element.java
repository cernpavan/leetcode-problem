class Solution {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        int idx=0;
        for(int i:nums){
            if(i!=val){
                nums[idx++]=i;
            }
        }
    return idx;
    }
}