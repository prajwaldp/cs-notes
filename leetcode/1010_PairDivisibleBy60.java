class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] remainders = new int[60];
        for (int t: time) {
            if (t % 60 == 0) {
                count += remainders[t % 60];
            } else {
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return count;
    }
}
