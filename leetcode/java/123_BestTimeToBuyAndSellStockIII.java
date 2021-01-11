class Solution {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[] prev = new int[n + 1];
    int[] curr = new int[n + 1];

    int bestBuy;
    int sell;
    int dontSell;

    for (int i = 1; i <= 2; i++) {
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