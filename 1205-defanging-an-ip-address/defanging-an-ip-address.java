class Solution {
    public String defangIPaddr(String address) {
      String res="";
      int len=address.length();

      for(int i=0;i<len;i++){
        if(address.charAt(i)=='.'){
            res+="[.]";
        }
        else{
            res+=address.charAt(i);
        }
      }
    return res;
    }
}