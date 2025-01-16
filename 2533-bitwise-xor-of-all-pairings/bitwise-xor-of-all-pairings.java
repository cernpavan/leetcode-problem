class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int ans=0;
        if(len1%2!=0){
            for(int i=0;i<len2;i++){
                ans^=nums2[i];
            }
        }
        if(len2%2!=0){
            for(int j=0;j<len1;j++){
                ans^=nums1[j];
            }
        }
        return ans;
    }
}