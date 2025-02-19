class Solution {
    public String getHappyString(int n, int k) {
        int totalWords = 3 * (int) Math.pow(2, n - 1);
        if (k > totalWords) return ""; // If k is out of range
        
        StringBuilder result = new StringBuilder();
        char[] letters = {'a', 'b', 'c'};
        
        k--; // Convert k to 0-based index
        int groupSize = totalWords / 3;
        int index = k / groupSize;
        result.append(letters[index]); // First character
        
        for (int i = 1; i < n; i++) {
            k %= groupSize; 
            groupSize /= 2; // Reduce group size for next character
            
            char lastChar = result.charAt(result.length() - 1);
            char firstOption = (lastChar == 'a') ? 'b' : 'a';
            char secondOption = (lastChar == 'c') ? 'b' : 'c';
            
            result.append((k / groupSize == 0) ? firstOption : secondOption);
        }
        
        return result.toString();
    }
}




// // a,b,c ->1,3
// // ab,ac,ba,bc,ca,cb->2,6

// 4

// 2^1=2
// bc
// // aba,abb,abc,   ->3,12

// // 3,6,12,24
// // 3*2^0,3*2^1,3*2^2,3*2^3

// 2^2=4

// 9%4
// 9/4= 2 ->1

// cab