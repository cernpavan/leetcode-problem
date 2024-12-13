class Solution {
    public long findScore(int[] nums) {
        int len=nums.length;
        boolean[] mark=new boolean[len];
        // Arrays.fill(mark,true);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> (a[0]==b[0]) ? (a[1]-b[1]) : (a[0]-b[0]));

        for(int i=0;i<len;i++){
            pq.offer(new int[] {nums[i],i});
        }

        long sum=0;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int val=curr[0];
            int index=curr[1];

            if(!mark[index]){
                sum+=val;
                mark[index]=true;


                if(index>0){
                    mark[index-1]=true;
                }
                if(index<len-1){
                    mark[index+1]=true;
                }
            }
        }
    return sum;
    }
}


// ArrayList<Boolean> mark= new ArrayList<>();

       

//         int len=nums.length;
//         int[] arr=new int[len];

//         for(int i=0;i<len;i++){
//             arr[i]=nums[i];
//             mark.add(true);
//         }

//         Arrays.sort(arr);
//         int sum=0;
//         for(int j:arr){
//             for(int i=0;i<len;i++){
//                 if(j==nums[i] && mark.get(i)==true){
//                     sum+=nums[i];
//                     mark.set(i,false);
//                     if(i+1!=len){
//                         mark.set(i+1,false);
//                     }
//                     if(i-1!=-1){
//                         mark.set(i-1,false);
//                     }
//                 }
//             }
//         }

//         return sum;