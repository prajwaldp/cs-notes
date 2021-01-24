from heapq import heappush, heappop
from collections import defaultdict
from typing import List

Matrix = List[List[int]]

class Solution:
    def diagonalSort(self, mat: Matrix) -> Matrix:
        diagonals = collections.defaultdict(list)
        m, n = len(mat), len(mat[0])
        for i in range(m):
            for j in range(n):
                heappush(diagonals[i - j], mat[i][j])

        for i in range(m):
            for j in range(n):
                mat[i][j] = heappop(diagonals[i - j])

        return mat
