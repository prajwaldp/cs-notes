class Solution:
    def minWindow(self, s: str, t: str) -> str:
        m, n = len(s), len(t)
        begin, min_len = -1, 20001
        dp = [-1] * n

        table = collections.defaultdict(list)
        for i, c in enumerate(t):
            table[c].append(i)

        for i, c in enumerate(s):
            if c not in table:
                continue

            for j in reversed(table[c]):
                if j == 0:
                    dp[0] = i
                else:
                    dp[j] = dp[j - 1]

                if j == n - 1 and dp[j] >= 0 and i - dp[j] + 1 < min_len:
                    begin = dp[j]
                    min_len = i - dp[j] + 1

        return "" if begin == -1 else s[begin:begin + min_len]


    def minWindow1(self, s: str, t:str) -> str:
        m, n = len(s), len(t)

        # dp[i][j] = k
        # where k = starting index in s that matches with t[0],
        #           i.e. t[0] = s[k], and
        #                t[:j + 1] is a subsequence of s[k:i + 1]

        dp = [[-1] * n for _ in range(m)]
        for i in range(m):
            if s[i] == t[0]:
                dp[i][0] = i
            elif i != 0:
                dp[i][0] = dp[i - 1][0]

        for i in range(1, m):
            for j in range(1, n):
                if s[i] == t[j]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = dp[i - 1][j]

        begin, min_len = -1, 20001
        for i in range(m):
            idx = dp[i][n - 1]
            if idx != -1:
                curr_len = i - idx + 1
                if curr_len < min_len:
                    min_len = curr_len
                    begin = idx

        return "" if begin == -1 else s[begin:begin + min_len]
