class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

        HashMap<Integer, Boolean> bannedMap = new HashMap<>();
        for (int num : banned) {
            bannedMap.put(num, true);
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!bannedMap.containsKey(i) && sum + i <= maxSum) {
                sum += i;
                count++;
            }
        }
        return count;
    }
}