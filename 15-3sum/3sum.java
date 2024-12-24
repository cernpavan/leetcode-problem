class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        Set<List<Integer>> res=new HashSet<>();
        
        for(int i=0;i<len;i++){
            HashSet<Integer> st=new HashSet<>();
            for(int j=i+1;j<len;j++){
                int third=-(nums[i]+nums[j]);
                
                if(st.contains(third)){
                                        
                    List<Integer> temp =new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    res.add(temp);
                    
                }
                else{
                    st.add(nums[j]);
                }
                
            }
        }
        List<List<Integer>> result=new ArrayList<>(res);
        return result;
    }
}