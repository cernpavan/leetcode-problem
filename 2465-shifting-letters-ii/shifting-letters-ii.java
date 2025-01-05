// class Solution {
//     public String shiftingLetters(String s, int[][] shifts) {
//         int len = s.length();
//         int[] pre = new int[len+1];
//         for (int i = 0; i < len; i++) {
//             pre[i] = 0;
//         }
        

//         int shiftlen = shifts.length;

//         for (int i = 0; i < shiftlen; i++) {
//             int start = shifts[i][0];
//             int end = shifts[i][1];
//             int eff = shifts[i][2];
//             if (eff == 0) eff = -1;
//             // for (int j = start; j <= end; j++) { 
//             //     pre[j] += eff;
//             // }  this istaking the time o(N^2)
//             pre[start]--;
//             pre[end+1]++;
//         }

//         int current=0;
//         for(int i=0;i<len;i++){
//             current+=pre[i];
//             pre[i]=current;
//         }

//         StringBuilder res = new StringBuilder();
//         for (int i = 0; i < len; i++) {
//             if (pre[i] != len) {
//                 int diff = pre[i] - len;
//                 int assci = s.charAt(i) - 'a';
//                 assci = (assci + (diff % 26) + 26) % 26; // Ensure positive modulo result
//                 char a = (char) (assci + 'a'); // Map back to the character
//                 res.append(a);
//             } else {
//                 res.append(s.charAt(i));
//             }

//         }
//         return res.toString();
//     }
// }

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        int[] pre = new int[len + 1]; // Use len + 1 for easier range manipulation

        int shiftlen = shifts.length;

        // Update prefix array for range shifts
        for (int i = 0; i < shiftlen; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int eff = shifts[i][2] == 1 ? 1 : -1; // Convert effect to +1 or -1
            pre[start] += eff;
            pre[end + 1] -= eff; // End + 1 for range logic
        }

        // Compute the prefix sum
        int current = 0;
        for (int i = 0; i < len; i++) {
            current += pre[i];
            pre[i] = current; // Store the cumulative shift at each position
        }

        // Build the resulting string
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int shift = pre[i] % 26; // Modulo 26 to keep within bounds
            int ascii = s.charAt(i) - 'a'; // Convert to 0-based index
            ascii = (ascii + shift + 26) % 26; // Apply shift and ensure positive result
            res.append((char) (ascii + 'a')); // Convert back to character
        }

        return res.toString();
    }
}
