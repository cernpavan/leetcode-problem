import java.util.HashMap;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false; // Ensure lengths are equal
        
        int swaps = 0;
        int len = s1.length();
        HashMap<Character, Integer> mpps = new HashMap<>();

        for (int j = 0; j < len; j++) {
            mpps.put(s1.charAt(j), mpps.getOrDefault(s1.charAt(j), 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            if (mpps.containsKey(s2.charAt(i)) && mpps.get(s2.charAt(i)) > 0) {
                mpps.put(s2.charAt(i), mpps.get(s2.charAt(i)) - 1);
            } else {
                return false;
            }

            if (s1.charAt(i) != s2.charAt(i)) {
                swaps++;
            }
            if (swaps > 2) {
                return false;
            }
        }
        return true;
    }
}
