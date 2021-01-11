class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:

        def union(pair: List[int]) -> None:
            u, v = pair
            rootU = find(u)
            rootV = find(v)

            if rank[rootU] > rank[rootV]:
                root[rootV] = rootU
            elif rank[rootU] < rank[rootV]:
                root[rootU] = rootV
            else:
                root[rootU] = rootV
                rank[rootV] += 1


        def find(x: int) -> int:
            if x != root[x]:
                root[x] = find(root[x])
            return root[x]


        n = len(s)
        root = list(range(n))
        rank = [0] * n
        ans = [''] * n

        for pair in pairs:
            union(pair)

        groups = collections.defaultdict(list)
        for i in range(n):
            groups[find(i)].append(i)

        for group_indices in groups.values():
            group_chars = [s[i] for i in group_indices]
            for i, c in zip(group_indices, sorted(group_chars)):
                ans[i] = c;

        return ''.join(ans)
