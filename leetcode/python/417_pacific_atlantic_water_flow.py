class Solution:
    def pacificAtlantic(self, matrix):
        def dfs(x, y, visited):
            if (y, x) in visited:
                return

            visited.add((y, x))
            for dx, dy in [(-1, 0), (1, 0), (0, 1), (0, -1)]:
                xx, yy = x + dx, y + dy

                if xx < 0 or yy < 0 or xx >= n or yy >= m:
                    continue

                if matrix[y][x] <= matrix[yy][xx]:
                    dfs(xx, yy, visited)

        if not matrix or not matrix[0]:
            return []

        m, n = len(matrix), len(matrix[0])
        pacific, atlantic = set(), set()

        for y in range(m):
            dfs(0, y, pacific)
            dfs(n - 1, y, atlantic)

        for x in range(n):
            dfs(x, 0, pacific)
            dfs(x, m - 1, atlantic)

        return list(pacific & atlantic)
