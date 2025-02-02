// class Solution {
//     public boolean check(int[] nums) {
//         int minv=Integer.MAX_VALUE;
//         int len=nums.length;
//         if(len==1){
//             return true;
//         }
//         int indx=-1;
//         for(int i=0;i<len;i++){
//             if(nums[i]<minv){
//                 minv=nums[i];
//                 indx=i;
//             }
//         }

//         // ->3
//         // ->2
//         // 0,1

//         3
//         4


//         for(int i=0;i<len-1;i++){
//             if(nums[(i+indx)%len]>nums[(i+indx+1)%len]){
//                 System.out.println(i);
//                 return false;
//             }
//         }

//         return true;
//     }
// }

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len]) {
                count++;
            }
        }
        
        return count <= 1;
    }
}
