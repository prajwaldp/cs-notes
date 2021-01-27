class Solution {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val m = heights.size
        val n = heights[0].size
        val distances = Array<IntArray>(m, { IntArray(n, Integer.MAX_VALUE) })
        val minHeap = PriorityQueue<IntArray> { a, b -> a[0] - b[0] }

        distances[0][0] = 0

        minHeap.offer(intArrayOf(0, 0, 0)) // {distance, row, col}
        while (!minHeap.isEmpty()) {
            val shortest = minHeap.poll()
            val shortestDist = shortest[0]
            val row = shortest[1]
            val col = shortest[2]
            if (row == m - 1 && col == n - 1) {
                return shortestDist
            }
            for (d in directions) {
                val nRow = row + d[0]
                val nCol = col + d[1]
                // If not a valid point on the grid
                if (nRow < 0 || nCol < 0 || nRow >= m || nCol >= n) {
                    continue
                }
                val potentialShortestDist = Math.max(shortestDist, Math.abs(heights[row][col] - heights[nRow][nCol]))
                if (potentialShortestDist < distances[nRow][nCol]) {
                    distances[nRow][nCol] = potentialShortestDist
                    minHeap.offer(intArrayOf(potentialShortestDist, nRow, nCol))
                }
            }
        }
        return -1 // unreachable
    }

    companion object {
        var directions = arrayOf<IntArray>(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0))
    }
}
