class Solution {
    public String clearDigits(String s) {
        int len=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<len;i++){
            char  temp=s.charAt(i);
            if(Character.isDigit(temp)){
                st.pop();
            }
            else{
                st.push(temp);
            }
        }
        StringBuilder sa=new StringBuilder();
        int stacklen=st.size();
        for(int i=0;i<stacklen;i++){
            sa.append(st.pop());
        }
        sa.reverse();
        return sa.toString();
    }
}