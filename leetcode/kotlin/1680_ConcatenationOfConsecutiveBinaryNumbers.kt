class Solution {
    fun concatenatedBinary(n: Int): Int {
        val MOD = 1_000_000_007
        var sum: Long = 0
        for (i in 1..n) {
            val num: Long = Math.pow(2.0, i.toString(2).length.toDouble()).toLong()
            sum = (sum * num + i) % MOD
        }
        return sum.toInt();
    }
}
