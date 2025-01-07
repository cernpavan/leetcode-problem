class Solution {
    public List<String> stringMatching(String[] words) {
        HashSet<String> res=new HashSet<>();
        for(String s:words){
            for(String j:words){
                if(s.contains(j) && s!=j){
                    res.add(j);
                }
            }
        }
        return new ArrayList<>(res);
    }
}