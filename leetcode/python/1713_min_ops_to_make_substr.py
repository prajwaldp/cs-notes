import bisect
from typing import List


class Solution:
    def minOperations(self, target: List[int], arr: List[int]) -> int:
        ntarget, narr = len(target), len(arr)

        dp: List[List[int]] = [[0] * (ntarget + 1)
                               for _ in range(narr + 1)]

        for i in range(1, narr + 1):
            for j in range(1, ntarget + 1):
                if arr[i] == target[j]:
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

        return dp[narr][ntarget]


class SolutionAlt:
    def min_operations(self, target: List[int], arr: List[int]) -> int:
        mapping = {e: i for i, e in enumerate(target)}
        dp = list()
        for a in arr:
            if a not in mapping:
                continue

            i = bisect.bisect_left(dp, mapping[a])

            if i == len(dp):
                dp.append(0)

            dp[i] = mapping[a]

        return len(target) - len(dp)
