class Solution {
  public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (k >= n / 2) {
      int maxProfit = 0;
      for (int i = 1; i < n; i++) {
        maxProfit += Math.max(0, prices[i] - prices[i - 1]);
      }
      return maxProfit;
    }

    int[] prev = new int[n + 1];
    int[] curr = new int[n + 1];

    int bestBuy;  // The buy price on a previous day on which the (i - 1)th
                  // transaction gave the best profit
    int sell;
    int dontSell;

    for (int i = 1; i <= k; i++) {
      bestBuy = Integer.MIN_VALUE;

      for (int d = 1; d <= n; d++) {
        dontSell = curr[d - 1];
        if (d >= 2) {
          bestBuy = Math.max(bestBuy, prev[d - 1] - prices[d - 2]);
        }

        sell = bestBuy + prices[d - 1];
        curr[d] = Math.max(sell, dontSell);
      }
      prev = Arrays.copyOf(curr, n + 1);
    }

    return curr[n];
  }
}