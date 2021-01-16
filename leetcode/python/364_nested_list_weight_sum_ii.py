from collections import deque


def depth_sum_inv(nested_list):
    q = deque(nested_list)
    level_sums = list()
    level_sum = 0

    while (n := len(q)) > 0:
        for _ in range(n):
            next_element = q.popleft()
            if next_element.isInteger():
                level_sum += next_element.getInteger()
            else:
                q.extend(next_element.getList())
        level_sums.append(level_sum)
        level_sum = 0

    total_sum = 0
    for i, e in enumerate(reversed(level_sums)):
        total_sum += (i + 1) * e
    return total_sum


def depth_sum_inv_alt(nested_list):
    unweighted = weighted = 0
    while nested_list:
        next_level = list()
        for l in nested_list:
            if l.isInteger():
                unweighted += l.getInteger()
            else:
                next_level.extend(l.getList())
        weighted += unweighted
        nested_list = next_level
    return weighted


class Solution:
    def depthSumInverse(self, nested_list):
        return depth_sum_inv_alt(nested_list)