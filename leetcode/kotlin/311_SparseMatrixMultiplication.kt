class Solution {
    fun multiply(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        val m = A.size
        val n = A[0].size
        val nB = B[0].size

        val C = Array<IntArray>(m, { IntArray(nB, { 0 }) })

        for (i in 0 until m) {
            for (k in 0 until n) {
                // Improve runtime for sparse matrices
                if (A[i][k] != 0) {
                    for (j in 0 until nB) {
                        C[i][j] += A[i][k] * B[k][j]
                    }
                }
            }
        }

        return C
    }
}
