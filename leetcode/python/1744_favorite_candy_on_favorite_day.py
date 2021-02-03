from itertools import accumulate


class Solution:
    def canEat(self, candiesCount, queries):
        prefix_sum = [0] + list(accumulate(candiesCount))

        res = list()

        for idx, (candy_type, fav_day, limit) in enumerate(queries):
            mx = prefix_sum[candy_type + 1] - 1
            mn = prefix_sum[candy_type] // limit
            res.append(mn <= fav_day <= mx)

        return res
