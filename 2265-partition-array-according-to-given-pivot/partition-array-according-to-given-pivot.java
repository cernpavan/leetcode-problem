class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len=nums.length;
        ArrayList<Integer> less=new ArrayList<>();
        ArrayList<Integer> more=new ArrayList<>();
        int noofPivot=0;
        for(int i=0;i<len;i++){
            if(nums[i]<pivot){
                less.add(nums[i]);
            }
            else if(nums[i]>pivot){
                more.add(nums[i]);
            }
            else{
                noofPivot++;
            }
        }

        int original=0;
        for(int i=0;i<less.size();i++){
            nums[original++]=less.get(i);
        }

        for(int i=0;i<noofPivot;i++){
            nums[original++]=pivot;
        }

        for(int i=0;i<more.size();i++){
            nums[original++]=more.get(i);
        }

        return nums;
    }
}