class Solution {
    fun getSmallestString(n: Int, k: Int): String {
        val sb = StringBuilder(n)
        sb.setLength(n)
        var k = k

        for (i in (n - 1) downTo 0) {
            val remaining = k - i;
            val letter = minOf(remaining, 26)
            sb.set(i, (letter + 96).toChar())
            k -= letter
        }

        return sb.toString()
    }
}
