class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        dist = [None] * len(s)
        indices = [i for i, c_ in enumerate(s) if c_ == c]
        prev, curr = None, 0
        for i in range(len(s)):
            if prev is None:
                dist[i] = indices[curr] - i
            elif curr == len(indices):
                dist[i] = i - indices[prev]
            else:
                dist[i] = min(abs(i - indices[curr]), abs(i - indices[prev]))

            if curr < len(indices) and i == indices[curr]:
                prev = curr
                curr += 1

        return dist
