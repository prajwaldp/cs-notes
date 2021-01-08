import java.util.*;

class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;

        Integer[] sortedIdx = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedIdx[i] = i;
        }

        Arrays.sort(sortedIdx, (x, y) -> A[x] - A[y]);
        int[] higher = buildMonotonicStack(sortedIdx);
        
        Arrays.sort(sortedIdx, (x, y) -> A[y] - A[x]);
        int[] lower = buildMonotonicStack(sortedIdx);

        boolean[] canHigher = new boolean[n];
        boolean[] canLower = new boolean[n];

        int count = 1; // We can stay in the last positon if we start there

        for (int i = n - 2; i >= 0; i--) {
            canHigher[i] = higher[i] == n - 1 || (higher[i] != -1 && canLower[higher[i]]);
            canLower[i] = lower[i] == n - 1 || (lower[i] != -1 && canHigher[lower[i]]);

            if (canHigher[i]) {
                count++;
            }
        }

        return count;
    }

    /**
     * Builds a monotonically decreasing stack and returns an array of next pointers
     */
    private int[] buildMonotonicStack(Integer[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.getFirst()] < nums[i]) {
                stack.removeFirst();
            }
            if (!stack.isEmpty()) {
                ans[nums[i]] = nums[stack.getFirst()];
            }
            stack.addFirst(i);
        }
        return ans;
    }

    public int oddEvenJumpsAlt(int[] A) {
        int n = A.length;
        boolean[] canHigher = new boolean[n];
        boolean[] canLower = new boolean[n];
        canHigher[n - 1] = canLower[n - 1] = true;
        
        TreeMap<Integer, Integer> valToIdx = new TreeMap<>();
        valToIdx.put(A[n - 1], n - 1);
        
        int count = 1;
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> lo = valToIdx.floorEntry(A[i]);
            Map.Entry<Integer, Integer> hi = valToIdx.ceilingEntry(A[i]);

            if (lo != null) {
                canLower[i] = canHigher[lo.getValue()];
            }
            if (hi != null) {
                canHigher[i] = canLower[hi.getValue()];
            }

            if (canHigher[i]) {
                count++;
            }

            valToIdx.put(A[i], i);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = {5, 4, 1, 2, 10, 8};
        var s = new Solution();
        int ans = s.oddEvenJumps(A);
        System.out.println(ans);
    }
}

// [5,4,1,2,10,8]
// sortedIdx = 2,3,1,0,5,4
