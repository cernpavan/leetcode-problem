class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        final int n = words.length;
        int count = 0;

        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isPrefixSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPrefixSuffix(String word1, String word2) {
        return word2.startsWith(word1) && word2.endsWith(word1);
    }
}