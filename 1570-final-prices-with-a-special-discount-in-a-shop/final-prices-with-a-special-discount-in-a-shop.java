class Solution {
    public int[] finalPrices(int[] prices) {
        int len=prices.length;

        for(int i=0;i<len-1;i++){
            int j=i+1;
            while(j<len-1 && prices[i]<prices[j]){
                j++;
            }
            if(prices[i]>=prices[j]){
                prices[i]-=prices[j];
            }

        }
        return prices;
    }
}