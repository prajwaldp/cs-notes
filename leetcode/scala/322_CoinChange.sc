object Solution {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    var dp = new Array[Int](amount + 1).map(_ => amount + 1)
    dp(0) = 0
    var i = 0
    
    for (c <- coins) {
      for (i <- c to amount) {
        dp(i) = Math.min(dp(i), dp(i - c) + 1)
      }
    }
    
    if (dp(amount) == amount + 1) -1 else dp(amount)
  }
}
