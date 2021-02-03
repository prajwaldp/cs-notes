class Solution:
    def numberOfPatterns(self, m: int, n: int) -> int:
        def dfs(num, length, count):
            if length >= m:
                count += 1

            if length >= n:
                return count

            length += 1

            visited[num] = True
            for next in range(1, 10):
                jump = skips[num][next]
                if not visited[next] and (jump == 0 or visited[jump]):
                    count = dfs(next, length, count)

            visited[num] = False
            return count

        skips = [[0] * 10 for _ in range(10)]
        skips[1][3] = skips[3][1] = 2
        skips[1][7] = skips[7][1] = 4
        skips[3][9] = skips[9][3] = 6
        skips[7][9] = skips[9][7] = 8
        skips[1][9] = skips[2][8] = skips[3][7] = skips[6][4] = skips[9][1] = skips[8][2] = skips[7][3] = skips[4][6] = 5

        visited = [False] * 10

        # starting from 1 is symmetric to starting from 3, 7, and 9
        # starting from 2 is symmetric to starting from 4, 6, and 8
        # hence the scalar multiplication by 4
        return dfs(1, 1, 0) * 4 + dfs(2, 1, 0) * 4 + dfs(5, 1, 0)
