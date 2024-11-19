class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        else if(x<10){
            return true;
        }
        int count=(int)(Math.log10(x)+1);
        long res=0;
        int dup=x;
        while(x>0){
            int div=x%10;
            res=res*10+div;
            x/=10;
        }
    return res==dup;
    }
}