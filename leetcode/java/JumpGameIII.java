class Solution {
    public boolean canReach(int[] arr, int start) {
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();
        q.addLast(start);

        while (!q.empty()) {
            int next = q.removeFirst();
            if (arr[next] == 0) return true;
            if (seen.contains(next) || next < 0 || next >= arr.length) continue;
            seen.add(next);
            q.addLast(next + arr[next]);
            q.addLast(next - arr[next]);
        }

        return false;
    }
}
