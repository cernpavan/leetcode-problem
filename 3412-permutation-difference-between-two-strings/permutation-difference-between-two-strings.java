class Solution {
    public int findPermutationDifference(String s, String t) {
        HashMap<Character,Integer> mpps=new HashMap<>();
        int len=s.length();

        for(int i=0;i<len;i++){
            mpps.put(s.charAt(i),i);
        }

        for(int i=0;i<len;i++){
            char val=t.charAt(i);
            int ind=Math.abs(mpps.get(val)-i);
            mpps.put(val,ind);
        }
        int sum=0;
        for (int val : mpps.values()) {
            sum += val;
        }


    return sum;
    }
}