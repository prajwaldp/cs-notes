class Solution:
    def countSubstringsAlt(self, s: str) -> int:
        n = count = len(s)
        dp = [[False] * n for _ in range(n)]

        for i in range(n):
            dp[i][i] = True

        for col in range(1, n):
            for row in range(i):
                if row == col - 1 and s[row] == s[col]:
                    dp[row][col] = True
                    count += 1
                elif dp[row + 1][col - 1] and s[row] == s[col]:
                    dp[row][col] = True
                    count += 1

        return count

    def countSubstrings(self, s: str) -> int:
        count = 0
        n = len(s)

        i = 0
        while i < n:
            j, k = i - 1, i
            while k < n - 1 and s[k] == s[k + 1]:
                k += 1

            count += (k - j) * (k - j + 1) // 2
            k += 1
            i = k

            while j >= 0 and k < n and s[k] == s[j]:
                j -= 1
                k += 1
                count += 1

        return count
