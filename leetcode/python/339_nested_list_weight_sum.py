from collections import deque


def depth_sum_recursive_dfs(nested_list, curr_depth=1):
    sum_ = 0
    for l in nested_list:
        if l.isInteger():
            sum_ += curr_depth * l.getInteger()
        else:
            sum_ += depth_sum_recursive_dfs(l.getList(), curr_depth + 1)
    return sum_


def depth_sum_bfs(nested_list):
    q = deque(nested_list)
    sum_, level = 0, 1
    while (n := len(q)) > 0:
        for _ in range(n):
            left_element = q.popleft()
            if left_element.isInteger():
                sum_ += level * left_element.getInteger()
            else:
                q.extend(left_element.getList())
        level += 1
    return sum_


class Solution:
    def depthSum(self, l):
        return depth_sum_bfs(l)
