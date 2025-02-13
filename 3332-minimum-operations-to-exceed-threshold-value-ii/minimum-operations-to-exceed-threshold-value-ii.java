import java.util.PriorityQueue;

// class Solution {
//     public int minOperations(int[] nums, int k) {
//         PriorityQueue<Long> pq = new PriorityQueue<>();
//         for (int num : nums) {
//             pq.offer((long) num); 
//         }

//         long count = 0;
//         while (pq.size() > 1 && pq.peek()<k) {
//             long a = pq.poll();
//             long b = pq.poll();
//             long val = (2 * a) + b;
//             count++;
//             pq.offer(val);
//         }

//         return (int)count;
//     }
// }
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            if(num<k) pq.add(num);
        }
        int op = 0;

        while(!pq.isEmpty()){
            int x = pq.poll();
            op++;
            if(pq.isEmpty()) break;
            int y = pq.poll();
            long up = 2l * x + y;
            if(up<k) pq.add((int)up);
        }
        return op;
    }
}