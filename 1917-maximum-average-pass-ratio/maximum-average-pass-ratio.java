class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
     
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        int len = classes.length;
      
        for (int i = 0; i < len; i++) {
            double gain = avgcal(i, classes);
            pq.offer(new double[] {gain, i});
        }

        
        while (extraStudents > 0) {
            double[] top = pq.poll();  
            int idx = (int) top[1];  
            classes[idx][0]++;
            classes[idx][1]++;
            double newGain = avgcal(idx, classes);  
            pq.offer(new double[] {newGain, idx}); 
            extraStudents--;
        }


        double sum = 0;
        for (int[] clazz : classes) {
            sum += (double) clazz[0] / clazz[1];
        }
        return sum / len;
    }


    private static double avgcal(int i, int[][] classes) {
        double currentRatio = (double) classes[i][0] / classes[i][1];
        double newRatio = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
        return newRatio - currentRatio;
    }
}


// class Solution {
//     public double maxAverageRatio(int[][] classes, int extraStudents) {
//         PriorityQueue<double[]> pq =new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        
//         int len=classes.length;
//         for(int i=0;i<len;i++){
//             double val=avgcal((int) i,classes);
//             pq.offer(new double[] {val,i});
//         }

//         while(extraStudents>0){
//             double[] dup=pq.poll();
//             int idx=(int) dup[1];
//             classes[idx][0]++;
//             classes[idx][1]++;
//             double val2=avgcal((int) idx,classes);
//             pq.offer(new double[] {val2,idx});
//             extraStudents--;
//         }
//         double sum=0;
//         for(double[] i:pq){
//             sum+=i[0];
//         }
//         return sum/len;
//     }

//     private static double avgcal(int i,int[][] classes){
//         double cal=(double) (classes[i][1]-classes[i][0])/(classes[i][1]*(classes[i][1]+1));
//         return cal;
//     }
// }