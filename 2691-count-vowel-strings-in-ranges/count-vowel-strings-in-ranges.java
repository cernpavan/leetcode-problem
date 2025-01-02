class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        // // HashMap<Integer,Integer> mpps=new HashMap<>();
        // PriorityQueue<Integer,Integer> mpps=new PriorityQueue<>((a,b)->a[0]-b[0]);
        // int[] res=new int[queries.length];
        // int count=0;
        // for(String s:words){
        //     boolean check=checkVowel(s);
        //     if(check){
        //         mpps.offer(count,1);
        //     }
        //     else{
        //         mpps.offer(count,0);
        //     }
        //     count++;
        // }
        // for(int i=0;i<queries.length;i++){
        //     int starting=queries[i][0];
        //     int ending=queries[i][1];
        //     for()
        // }
        int[] res=new int[queries.length];
        int[] prefix=new int[words.length];
        int indx=0;
        for(String s:words){
            if(checkVowel(s)){
                prefix[indx]=1;
            }
            else{
                prefix[indx]=0;
            }
            indx++;
        }
        
        
        for(int i=1;i<words.length;i++){
            prefix[i]+=prefix[i-1];
        }

        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            
            // for(int j=start;j<=end;j++){
            //     if(checkVowel(words[j])){
            //         count++;
            //     }
            // }
             res[i] = prefix[end] - (start > 0 ? prefix[start - 1] : 0);

        }
        return res;
    }
    public static boolean checkVowel(String s){
        ArrayList<Character> vowel=new ArrayList<>(Arrays.asList('a','e','i','o','u'));
        int len=s.length();
        return vowel.contains(s.charAt(0)) && vowel.contains(s.charAt(len-1));
    }
}