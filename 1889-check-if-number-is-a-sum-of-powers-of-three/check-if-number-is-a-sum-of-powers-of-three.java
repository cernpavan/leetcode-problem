class Solution {
    public boolean checkPowersOfThree(int n) {

        boolean flag=false;
        HashSet<Integer> mp=new HashSet<>();
        while(n>0){
            int count=0;
            while(Math.pow(3,count)<=n){
                count++;
            }
            if(mp.contains(count-1)){
                return false;
            }
            mp.add(count-1);
            n-=Math.pow(3,count-1);
        }
        return true;        
    }
}

// 11

// 9->2
// 1->1
// 1->1

