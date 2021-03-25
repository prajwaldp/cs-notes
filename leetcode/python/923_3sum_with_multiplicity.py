from collections import defaultdict, Counter
from itertools import permutations


class Solution:
    def threeSumMulti(self, arr, target):
        count = Counter(arr)
        res = 0
        MOD = int(1e9 + 7)
        for i, j in permutations(count, 2):
            if i < j < target - i - j:
                res = (res + count[i] * count[j] * count[target - i - j]) % MOD

        for i in count:
            if 3 * i != target:
                res = (res + count[i] * (count[i] - 1) *
                       count[target - 2 * i] // 2) % MOD
            else:
                res = (res + count[i] * (count[i] - 1)
                       * (count[i] - 2) // 6) % MOD

        return res

    def threeSumMultiAlt(self, arr, target):
        mp = defaultdict(int)
        res = 0
        MOD = 1e9 + 7
        for i in range(len(arr)):
            res = (res + mp[target - arr[i]]) % MOD
            for j in range(i):
                mp[arr[i] + arr[j]] += 1

        return int(res)
