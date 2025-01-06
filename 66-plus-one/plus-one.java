// class Solution {
//     public int[] plusOne(int[] digits) {
//         int len=digits.length;
//         if(digits[len-1]!=9){
//             digits[len-1]=digits[len-1]+1;
//             return digits;
//         }
      
//         int num=0;
//         for(int i:digits){
//             num=num*10+i;
//         }
//         num++;
//         int numlen=(int) (Math.log10(num))+1;
//         int idx=0;
//         if(numlen!=len){
//             int[] res=new int[len+1];
//             idx=len;
//         }
//         else{
//             int[] res=new int[len];
//             idx=len-1;
//         }

        
//         while(num>0){
//             int rem=num%10;
//             num/=10;
//             res[idx--]=rem;
//         }
//         return res;
//     }
// }
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        // Start from the last digit and handle carry
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry, return the result
            }
            digits[i] = 0; // Set to 0 and continue for carry
        }

        // If we reach here, all digits were 9
        int[] result = new int[len + 1];
        result[0] = 1; // The rest are already 0
        return result;
    }
}
