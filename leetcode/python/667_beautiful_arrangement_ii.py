class Solution:
    def constructArray(self, n, k):
        if k == 1:
            return list(range(1, n + 1))

        l, r = 1, n
        arrangement = []

        for i in range(n):
            if i % 2 == 0:
                arrangement.append(l)
                l += 1
            else:
                arrangement.append(r)
                r -= 1

            k -= 1

            if k == 1:
                return arrangement + (list(range(l, r + 1)) if i % 2 == 1 else list(range(r, l - 1, -1)))

        return []

    def constructArrayAlt(self, n, k):
        arrangement = []
        l, r = 1, n
        while l <= r:
            if k > 1:
                if k % 2 == 0:
                    arrangement.append(l)
                    l += 1
                else:
                    arrangement.append(r)
                    r -= 1

                k -= 1
            else:
                arrangement.append(r)
                r -= 1

        return arrangement
