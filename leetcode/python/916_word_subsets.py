from collections import Counter


class Solution:
    def wordSubsets(self, A, B):
        b_freq = Counter()
        for word in B:
            b_freq |= Counter(word)

        if sum(b_freq.values()) > 10:
            return []

        return [w for w in A if not b_freq - Counter(w)]
