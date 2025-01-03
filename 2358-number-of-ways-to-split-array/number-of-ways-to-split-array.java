class Solution {
    public int waysToSplitArray(int[] nums) {
        // int len=nums.length;
        // long[] prefix=new long[len];
        // long[] suffix=new long[len];
        // long presum=0;
        // for(int i=0;i<len;i++){
        //     presum+=nums[i];
        //     prefix[i]=presum;
        // }

        // long sufsum=0;
        // for(int i=len-1;i>=0;i--){
        //     sufsum+=nums[i];
        //     suffix[i]=sufsum;
        // }
        // int validSplits=0;
        // for(int i=0;i<len-1;i++){
        //     if(prefix[i]>=suffix[i+1]){
        //         validSplits++;
        //     }
        // }
        // return validSplits;

        int len=nums.length;
        long sum=0;
        for(int i:nums){
            sum+=i;
        }

        int j=0;
        int validSplits=0;
        long n=0;
        while(j<len-1){
            n+=nums[j];
            long rem=sum-n;

            if(n>=rem){
                validSplits++;
            }

            j++;
        }
        return validSplits;
    }
}