class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Character.compare(b, a));
        for (char ch : freq.keySet()) {
            pq.offer(ch);
        }

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int count = freq.get(ch);

            int use = Math.min(count, repeatLimit);
            for (int i = 0; i < use; i++) {
                result.append(ch);
            }

            freq.put(ch, count - use);

            if (freq.get(ch) > 0 && !pq.isEmpty()) {
                char nextCh = pq.poll();
                result.append(nextCh);
                freq.put(nextCh, freq.get(nextCh) - 1);

                if (freq.get(nextCh) > 0) {
                    pq.offer(nextCh);
                }
                pq.offer(ch);
            }
        }
        return result.toString();
    }
}