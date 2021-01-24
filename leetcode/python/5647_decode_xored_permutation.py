'''
          x       y
original: 2 4 1 5 3
encoded:   6 5 4 6

n = len(encoded) + 1
x^5^6 (i.e. x ^ numbers at odd indices) = reduce(xor, 1..n)
'''

from functools import reduce


class Solution:
    def decode(self, encoded: List[int]) -> List[int]:
        x = 0
        n = len(encoded) + 1
        for i, num in enumerate(encoded):
            if i % 2 == 1:
                x ^= num

        ans = [x ^ reduce(lambda x, y: x ^ y, range(1, n + 1))]
        for n in encoded:
            ans.append(ans[-1] ^ n)

        return ans
