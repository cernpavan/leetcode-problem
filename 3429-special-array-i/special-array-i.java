class Solution {
    public boolean isArraySpecial(int[] nums) {
        int len=nums.length;
        if(len==1){

            return true;
        }

        for(int i=0;i<len-1;i++){
            int sum=nums[i]+nums[i+1];
            if(sum%2==0){
                return false;
            }
        }
        return true;
    }
}