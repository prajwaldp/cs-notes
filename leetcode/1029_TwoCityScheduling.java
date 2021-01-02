class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        Arrays.sort(costs, (x, y) -> x[0] - x[1] - y[0] + y[1]);

        int cost = 0;
        for (int i = 0; i < n; i++) {
            cost += i < n / 2 ? costs[i][0] : costs[i][1];
        }

        return cost;
    }
}
