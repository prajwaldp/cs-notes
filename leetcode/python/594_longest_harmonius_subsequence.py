from collections import Counter


class Solution:
    def findLHS(self, nums: List[int]) -> int:
        count = Counter(nums)
        result = 0
        for i in count:
            if i + 1 in count:
                result = max(result, count[i] + count[i + 1])

        return result

