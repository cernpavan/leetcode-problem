class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res=0;
        for(String s:operations){
            if(s.charAt(0)=='+' || s.charAt(2)=='+'){
                res++;
            }
            else{
                res--;
            }

        }
        return res;
    }
}