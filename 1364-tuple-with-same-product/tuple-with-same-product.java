class Solution {
    public int tupleSameProduct(int[] nums) {
        int len=nums.length;
        if(len<4){
            return 0;
        }
        HashMap<Integer,Integer> mpps=new HashMap<>();

        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int val=nums[i]*nums[j];
                mpps.put(val,mpps.getOrDefault(val,0)+1);
            }
        }

        int ans=0;
        for(int k:mpps.values()){
            if(k>1){
                ans+=((k*(k-1))/2)*8;
            }
        }

        return ans;
    }
}