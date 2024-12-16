class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        int len=nums.length;

        for(int i=0;i<len;i++){
            pq.offer(new int[] {nums[i],i});
        }
        
        for(int i=0;i<k;i++){
            int[] sv=pq.poll();
            int val=sv[0]*multiplier;
            int idx=sv[1];
            pq.offer(new int[] {val,idx});
        }

        int[] res=new int[len];

        for(int[] p:pq){
            res[p[1]]=p[0];
        }

    return res;
    }
}