import java.util.*;

class Main {
    public static void main(String[] args) {
        var s = new Solution();
        int[] nums = {2,4,3,3,5,4,9,6};
        int k = 4;
        System.out.println(Arrays.toString(s.mostCompetitive(nums, k)));

        nums = new int[] {3, 5, 2, 6};
        k = 2;
        System.out.println(Arrays.toString(s.mostCompetitive(nums, k)));

        nums = new int[] {2,9,9,9,9,8,7,7};
        k = 4;
        System.out.println(Arrays.toString(s.mostCompetitive(nums, k)));
    }
}

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            int remaining = len - i;

            while (!stack.isEmpty() && stack.getFirst() > n
                   && remaining >= k - (stack.size() - 1)) {
                stack.removeFirst();
            }
            stack.addFirst(n);
        }

        while (stack.size() > k) stack.removeFirst();

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = stack.removeFirst();
        }

        return ans;
    }
}