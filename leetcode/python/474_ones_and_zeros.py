class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        
        @lru_cache(None)
        def dp(i, j, k, curr):
            nonlocal best
            if i < 0 or j < 0:
                return
            
            best = max(best, curr)
            
            if k == len(strs):
                return
            
            zeros_count = strs[k].count('0')
            ones_count = strs[k].count('1')
            
            dp(i, j, k + 1, curr),
            dp(i - zeros_count, j - ones_count, k + 1, curr + 1)
        
        best = 0
        dp(m, n, 0, 0)
        return best
