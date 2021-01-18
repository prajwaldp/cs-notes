from collections import defaultdict


def tuple_with_same_product(nums):
    n = len(nums)
    count = defaultdict(int)
    for i in range(n):
        for j in range(i + 1, n):
            count[nums[i] * nums[j]] += 1

    total = 0
    for c in count.values():
        if c >= 2:
            total += c * (c - 1) * 4

    return total


class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        return tuple_with_same_product(nums)
