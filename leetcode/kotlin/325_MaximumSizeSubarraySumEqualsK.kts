import kotlin.math.max;

class Solution {
    fun maxSubArrayLen(nums: IntArray, k: Int): Int {
        var sum = 0
        var ans = 0
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            sum += nums[i]
            if (sum == k) ans = i + 1
            map.getOrPut(sum, { i })

            if (map.contains(sum - k)) ans = maxOf(ans, i - map[sum - k]!!)
        }

        return ans
    }
}

fun main() {
    val s = Solution()
    val ans = s.maxSubArrayLen(intArrayOf(1, -1, 5, -2, 3), 3)
    println(ans)
}

main()
