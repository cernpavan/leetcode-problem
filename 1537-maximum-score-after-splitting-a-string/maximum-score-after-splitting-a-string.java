class Solution {
    public int maxScore(String s) {
        int len=s.length();
        int noOfZeros=0;
        int noOfOnes=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='0'){
                noOfZeros++;
            }
            else{
                noOfOnes++;
            }
        }
        int result=noOfOnes;
        int finalv=Integer.MIN_VALUE;
        for(int i=0;i<len-1;i++){
            if(s.charAt(i)=='0'){
                result++;
            }
            else{
                result--;
            }
            finalv=Math.max(result,finalv);
        }
        return finalv;
    }
}