class Solution {
    public int countPalindromicSubsequence(String s) {
        // HashMap<Character,Integer> mpps=new HashMap<>();
        // int len=s.length();
        // int res=0;
        // for(int i=0;i<len;i++){
        //     char al=s.charAt(i);
        //     if(mpps.containsKey(al)){
        //         if(mpps.get(al)!=i-1){
        //             res+=i-mpps.get(al);
        //         }
        //     }
        //     mpps.put(al,i);
        // }
        // return res;
        
        int[] front=new int[26];
        int[] end=new int[26];

        for(int i=0;i<26;i++){
            front[i]=Integer.MAX_VALUE;
            end[i]=Integer.MIN_VALUE;
        }

        for(int i=0;i<s.length();i++){
            int indx=s.charAt(i)-'a';
            front[indx]=Math.min(front[indx],i);
            end[indx]=Math.max(end[indx],i);
        }

        int res=0;
        for(int i=0;i<26;i++){

            if(front[i]==Integer.MAX_VALUE || end[i]==Integer.MIN_VALUE){
                continue;
            }

            HashSet<Character> st=new HashSet<>();

            for(int j=front[i]+1 ;j<end[i];j++){
                st.add(s.charAt(j));
            }
            res+=st.size();
        }
        return res;
    }
}