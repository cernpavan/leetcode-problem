class Solution {
    public int minimumSize(int[] nums, int maxOps) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        while (low < high) {
            int mid = (low + high) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += (n - 1) / mid;
            }
            if (ops <= maxOps) high = mid;
            else low = mid + 1;
        }
        return high;
    }
}
//         int len=nums.length;
//         int maxv=Integer.MIN_VALUE;
//         for(int i=0;i<len;i++){
//             maxv=Math.max(maxv,nums[i]);
//         }
//         int l=0;
//         int r=maxv;
//         while(l<r){
//             int mid=l+(r-l)/2;
//             boolean val=check(maxv,mid,maxOperations);
//             if(val){
//                 l=mid-1;
//             }
//             else{
//                 r=mid+1;
//             }
//         }
//         return r;
//     }

//     private boolean check(int num,int mid,int max){
//         int val=0;
//         for(int i=0;i<len;i++){
//             val+=Math.ceil((double) q[i]/che);
//         }
//         return max>=val-1;
//     }
// }