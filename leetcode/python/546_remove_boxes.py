# Observations
# 1. Define T(i, j) as the maximum number of points you can get by removing boxes[i..j]
# 2. T(i, i) = 1, points obtained by removing 1 box
# 3. T(i, i - 1) = 0, when there are no boxes left
#
# Suppose you remove just boxes[i], max points = 1 + T(i + 1, j)
# Suppose you want to group boxes[i] with boxes[m] (as boxes[i] = boxes[m]),
# max points = T(i + 1, m - 1) + max points from concatenation_of(boxes[i], boxes[m, j])
# Important Observation: boxes[m, j] is a not a self-contained sub-problem, i.e
# its solution depends on extra information external to the sub-problem
# The extra information is the number of boxes of the same color to the left of boxes[i]
#
# Re-framing the problem to include the extra information
# T(i, j, k) is the maximum number of points you can get by removing boxes[i..j]
# with k boxes to the left of boxes[i..j] with the same color as boxes[i]
#
# Base cases
# ==========
# T(i, i - 1, k) = 0
# T(i, i, k) = (k + 1) * (k + 1)
#
# Recurrence relation
# ===================
# Option 1. Removes boxes[i]
# Max points = (k + 1) * (k + 1) + T(i + 1, j, 0)
#
# Option 2. Attach boxes[i] with boxes[m]
# Max points =
#   T(i + 1, m - 1, 0)
# + T(m, j, k + 1)
#
# But there could be multiple boxes of the same color as boxes[i] in boxes[i..j]
# Therefore, final ans for option 2 =
#   max(T(i + 1, m - 1, 0) + T(m, j, k + 1) for m in i..j if boxes[i] == boxes[m])

def top_down_impl(boxes):
    n = len(boxes)
    dp = [None] * n
    for i in range(n):
        dp[i] = [[0] * n for _ in range(n)]

    return top_down_impl_sub(boxes, 0, n - 1, 0, dp)


def top_down_impl_sub(boxes, i, j, k, dp):
    if i > j:
        return 0
    if dp[i][j][k] > 0:
        return dp[i][j][k]

    while i + 1 <= j and boxes[i] == boxes[i + 1]:
        i += 1
        k += 1

    res = (k + 1) * (k + 1) + top_down_impl_sub(boxes, i + 1, j, 0, dp)

    for m in range(i + 1, j + 1):
        if boxes[i] == boxes[m]:
            res = max(
                res,
                top_down_impl_sub(boxes, i + 1, m - 1, 0, dp) + \
                top_down_impl_sub(boxes, m, j, k + 1, dp)
            )

    dp[i][j][k] = res
    return res


def bottom_up_impl(boxes):
    n = len(boxes)
    if n == 0:
        return 0

    dp = [None] * n
    for i in range(n):
        dp[i] = [[0] * n for _ in range(n)]

    for i in range(n):
        for k in range(i + 1):
            dp[i][i][k] = (k + 1) * (k + 1)

    for l in range(1, n):
        for j in range(l, n):
            i = j - l
            for k in range(i + 1):
                res = (k + 1) * (k + 1) + dp[i + 1][j][0]
                for m in range(i + 1, j + 1):
                    if boxes[i] == boxes[m]:
                        res = max(
                            res,
                            dp[i + 1][m - 1][0] + dp[m][j][k + 1]
                        )
                dp[i][j][k] = res

    return dp[0][n - 1][0]


class Solution:
    def removeBoxes(self, boxes: List[int]) -> int:
        return bottom_up_impl(boxes)
