function coinChange(coins: number[], amount: number): number {
  let dp = new Array(amount + 1).fill(amount + 1)
  dp[0] = 0
  
  for (let c of coins) {
    for (let i = c; i <= amount; i++) {
      dp[i] = Math.min(dp[i - c] + 1, dp[i])
    }
  }
  
  return dp[amount] == amount + 1 ? -1 : dp[amount]
};
