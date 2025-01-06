class Solution {
    public int[] minOperations(String boxes) {
        int len=boxes.length();
        int[] res=new int[len];
       
        for(int i=0;i<len;i++){
            char ichar=boxes.charAt(i);
            
                int ans=0;
            for(int j=0;j<len;j++){
                char a=boxes.charAt(j);
                if(a=='1'){
                    ans+=Math.abs(j-i);
                }
            }
            res[i]=ans;
            
        }
        return res;
    }
}