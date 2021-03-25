class Solution:
    def advantageCount(self, A, B):
        n = len(A)
        order = sorted(range(n), key=lambda x: B[x], reverse=True)
        ans = [-1] * n
        A = deque(sorted(A))
        for ix in order:
            ans[ix] = A.pop() if A[-1] > B[ix] else A.popleft()
        return ans

    def advantageCountAlt(self, A, B):
        ans = []
        A.sort()

        for num in B:
            val = bisect_right(A, num)
            ans.append(A.pop(0) if val == len(A) else A.pop(val))

        return ans
