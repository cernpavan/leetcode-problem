class Solution {
    public int scoreOfString(String s) {
        int sum=0;
        int len=s.length();
        for(int i=0;i<len-1;i++){
            sum+=Math.abs(s.charAt(i)-s.charAt(i+1));
        }
    return sum;
    }
}