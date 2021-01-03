class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(new int[] { intervals[0][0], intervals[0][1] });

        for (int i = 1; i < intervals.length; i++) {
            int currInt[] = merged.get(merged.size() - 1);

            if (intervals[i][0] <= currInt[1]) {
                currInt[1] = Math.max(currInt[1], intervals[i][1]);
            } else {
                merged.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }

        int n = merged.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = merged.get(i)[0];
            ans[i][1] = merged.get(i)[1];
        }

        return ans;
    }
}