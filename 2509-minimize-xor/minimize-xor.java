class Solution {
    public int minimizeXor(int num1, int num2) {
        int count2 = Integer.bitCount(num2);

        int count1 = Integer.bitCount(num1);

        if (count1 == count2) {
            return num1;
        }

        int result = num1;

        if (count1 > count2) {
            for (int i = 0; i < 32 && count1 > count2; i++) {
                if ((result & (1 << i)) != 0) {
                    result &= ~(1 << i);
                    count1--;
                }
            }
        } else {
            for (int i = 0; i < 32 && count1 < count2; i++) {
                if ((result & (1 << i)) == 0) {
                    result |= (1 << i); 
                    count1++;
                }
            }
        }

        return result;
    }
}