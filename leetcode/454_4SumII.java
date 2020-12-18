class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> abFreq = new HashMap<>();
        for (int a: A) {
            for (int b: B) {
                abFreq.put(a + b, abFreq.getOrDefault(a + b, 0) + 1);
            }
        }
        int ans = 0;
        for (int c: C) {
            for (int d: D) {
                if (abFreq.containsKey(-c - d)) {
                    ans += abFreq.get(-c - d);
                }
            }
        }
        return ans;
    }
}
