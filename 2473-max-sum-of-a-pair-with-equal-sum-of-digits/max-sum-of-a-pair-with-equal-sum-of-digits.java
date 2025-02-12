// class Solution {
//     public int maximumSum(int[] nums) {
//         HashMap<Integer,int[]> mpps=new HashMap<>();
//         int len=nums.length;
//         for(int i=0;i<len;i++){
//             int sum=0;
//             int val=nums[i];
//             while(val>0){
//                 sum+=val%10;
//                 val/=10;
//             }
//             if(!mpps.containsKey(sum)){
//                 mpps.put(sum,i);
//             }
//         }

//         int ans=-1;
//         for(int[] i:mpps.values()){

//             if(i.length>1){
//                 Arrays.sort(i);
//                 int lens=i.length;
//                 ans=Math.max(ans,i[len-1]+i[len-2]);
//             }
//         }
//     return ans;
//     }
// }
import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        // HashMap to store sum of digits as key and a list of numbers with that sum as value
        HashMap<Integer, ArrayList<Integer>> mpps = new HashMap<>();
        int len = nums.length;

        // Iterate through all numbers in the array
        for (int i = 0; i < len; i++) {
            int sum = 0;
            int val = nums[i];

            // Calculate the sum of digits of the number
            while (val > 0) {
                sum += val % 10;
                val /= 10;
            }

            // If the sum is not present, initialize a new list
            mpps.putIfAbsent(sum, new ArrayList<>());
            // Add the current number to the list
            mpps.get(sum).add(nums[i]);
        }

        int ans = -1;

        // Iterate through the map values (lists of numbers)
        for (ArrayList<Integer> list : mpps.values()) {
            // If there are at least two numbers with the same digit sum
            if (list.size() > 1) {
                // Sort the list to get the two largest numbers
                Collections.sort(list);
                int lens = list.size();
                // Update the maximum sum of two numbers
                ans = Math.max(ans, list.get(lens - 1) + list.get(lens - 2));
            }
        }

        return ans;
    }
}
