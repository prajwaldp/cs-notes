DIRECTIONS = [(0, 1), (0, -1), (1, 0), (-1, 0)]


def num_islands(m, n, positions):
    root = [-1] * (m * n)
    ans = list()
    count = 0
    for i, j in positions:
        curr_island = i * n + j;
        if root[curr_island] != -1:
            ans.append(count)
            continue

        root[curr_island] = curr_island
        count += 1
        for di, dj in DIRECTIONS:
            r = i + di
            c = j + dj
            neigh_island = r * n + c
            if r < 0 or c < 0 or r >= m or c >= n or root[neigh_island] == -1:
                continue
            neigh_island_root = find(root, neigh_island)
            if root[curr_island] != neigh_island_root:
                root[curr_island] = neigh_island_root
                curr_island = neigh_island_root
                count -= 1
        ans.append(count)
    return ans


def find(root, i):
    if i != root[i]:
        root[i] = find(root, root[i])
    return root[i]


class Solution:
    def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
        return num_islands(m, n, positions)
