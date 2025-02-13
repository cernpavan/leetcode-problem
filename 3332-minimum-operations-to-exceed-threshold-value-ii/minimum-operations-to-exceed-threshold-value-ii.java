import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num); 
        }

        long count = 0;
        while (pq.size() > 1 && pq.peek()<k) {
            long a = pq.poll();
            long b = pq.poll();
            long val = (2 * a) + b;
            count++;
            pq.offer(val);
        }

        return (int)count;
    }
}
