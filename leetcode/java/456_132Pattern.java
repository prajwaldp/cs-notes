import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        // Given: x x x i x x x j x x x k x x x
        //                                    ^
        //                                    The pointer starts here
        //              ^
        //              When the pointer reaches here, it must be established that j and k exist, such that
        //              - k appears before j (in the right to left traversal)
        //              - k < j
        //              - we can now compare i and k, and verify that i < k

        Deque<Integer> stack = new ArrayDeque<>();

        int n = nums.length;
        int k = Integer.MIN_VALUE;
        for (int idx = n - 1; idx >= 0; idx--) {
            if (nums[idx] < k) {
                // nums[idx] is a solution for i
                return true;
            } else {
                // nums[idx] is a possible candidate for j
                // So get the max possible k, for j = nums[idx]
                while (!stack.isEmpty() && stack.getFirst() < nums[idx]) {
                    // There is a definitely a number that is greater than k, i.e. nums[idx]
                    k = stack.removeFirst();
                }
                stack.addFirst(nums[idx]);
            }
        }
        return false;
    }
    
    public boolean find132patternAlt(int[] nums) {
        int n = nums.length;
        
        int[] mins = new int[n];
        mins[0] = nums[0];
        for (int i = 1; i < n; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int j = n - 1; j >= 0; j++) {
            if (nums[j] > mins[j]) {
                while (!stack.isEmpty() && stack.getFirst() <= mins[j]) {
                    stack.removeFirst();
                }

                if (!stack.isEmpty() && stack.getFirst() < nums[j]) {
                    return true;
                }

                stack.addFirst(nums[j]);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Solution soln = new Solution();
        System.out.println(soln.find132pattern(new int[] {2, 3, 4, 1, 2, 3, 4, 2}));
    }
}
