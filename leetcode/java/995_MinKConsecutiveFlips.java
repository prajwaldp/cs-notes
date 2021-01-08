class Solution {
    public int minKBitFlips(int[] A, int K) {
        Deque<Integer> indicesFlipped = new ArrayDeque<>();
        boolean flipped;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            // Has the current element been flipped before
            flipped = indicesFlipped.size() % 2 != 0;
            
            if (A[i] == 1 && flipped || A[i] == 0 && !flipped) {
                // Cannot flip A[n]
                if (i + K - 1 >= A.length) {
                    return -1;
                }
                
                res++;

                // The last index that is going to be flipped
                indicesFlipped.addLast(i + K - 1);
            }

            if (!indicesFlipped.isEmpty() && i == indicesFlipped.getFirst()) {
                indicesFlipped.removeFirst();
            }
        }
        return res;
    }
}

