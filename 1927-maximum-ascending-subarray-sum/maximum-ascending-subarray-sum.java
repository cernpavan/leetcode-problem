class Solution {
    public int maxAscendingSum(int[] nums) {
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        int sum=nums[0];
        int ans=nums[0];

        for(int i=1;i<len;i++){
            if(nums[i-1]<nums[i]){
                sum+=nums[i];
            }
            else{
                sum=nums[i];
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}