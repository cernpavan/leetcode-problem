class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len=nums.length;
        int si=1;
        int sd=1;
        int ans=1;
        for(int i=0;i<len-1;i++){
            if(nums[i]>nums[i+1]){
                sd=1;
                si++;
            }
            else if(nums[i]<nums[i+1]){
                sd++;
                si=1;
            }
            else{
                sd=1;
                si=1;
            }
            ans=Math.max(ans,Math.max(sd,si));
        }
        return ans;
    }
}