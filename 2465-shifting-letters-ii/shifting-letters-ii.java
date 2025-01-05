class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        int[] pre = new int[len];
        for (int i = 0; i < len; i++) {
            pre[i] = len;
        }

        int shiftlen = shifts.length;

        for (int i = 0; i < shiftlen; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int eff = shifts[i][2];
            if (eff == 0) eff = -1;
            for (int j = start; j <= end; j++) { // Note: End is inclusive
                pre[j] += eff;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (pre[i] != len) {
                int diff = pre[i] - len;
                int assci = s.charAt(i) - 'a';
                assci = (assci + (diff % 26) + 26) % 26; // Ensure positive modulo result
                char a = (char) (assci + 'a'); // Map back to the character
                res.append(a);
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
