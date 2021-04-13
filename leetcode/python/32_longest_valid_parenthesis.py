class Solution:
    def longestValidParentheses(self, s):
        stk = [-1]
        longest = 0
        for i, c in enumerate(s):
            if c == '(':
                stk.append(i)
            else:
                stk.pop()
                if not stk:
                    stk.append(i)
                else:
                    longest = max(longest, i - stk[-1])

        return longest

    def longestValidParenthesisAlt(self, s):
        n = len(s)
        if n <= 1:
            return 0

        longest = 0
        dp = [0] * n
        for i in range(1, n):
            if s[i] == ')' and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == '(':
                dp[i] = dp[i - 1] + 2 + max(dp[i - dp[i - 1] - 2], 0)
                longest = max(longest, dp[i])

        return longest
