import bisect


class Solution:
    def maxEnvelopes(self, envelopes):
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        dp = []
        for _, h in envelopes:
            idx = bisect.bisect_left(dp, h)

            if idx < len(dp):
                dp[idx] = h
            else:
                dp.append(h)

        return len(dp)
