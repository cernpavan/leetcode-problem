class Solution {
    public String getHappyString(int n, int k) {
        // Calculate the total number of happy strings of length n
        int totalWords = 3 * (int) Math.pow(2, n - 1);
        
        // If k is greater than the total possible strings, return an empty string
        if (k > totalWords) return ""; 
        
        StringBuilder result = new StringBuilder(); // To store the final happy string
        
        char[] letters = {'a', 'b', 'c'}; // The allowed characters
        
        k--; // Convert k to 0-based index for easier calculations
        int groupSize = totalWords / 3; // Determines the number of strings starting with each letter
        int index = k / groupSize; // Find which letter should be the first character
        result.append(letters[index]); // Append the first character
        
        // Iterate to determine the rest of the characters in the string
        for (int i = 1; i < n; i++) {
            k %= groupSize; // Update k for the next character selection
            groupSize /= 2; // Reduce the group size for the next character
            
            // Get the last character added to the result
            char lastChar = result.charAt(result.length() - 1);
            
            // Define the next possible characters (ensuring no repetition)
            char firstOption = (lastChar == 'a') ? 'b' : 'a';
            char secondOption = (lastChar == 'c') ? 'b' : 'c';
            
            // Choose the next character based on the updated k value
            result.append((k / groupSize == 0) ? firstOption : secondOption);
        }
        
        return result.toString(); // Return the k-th lexicographical happy string
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