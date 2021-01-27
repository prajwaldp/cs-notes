class Solution:
    def isOneEditDistance(self, s, t):
        if len(s) > len(t):
            return self.isOneEditDistance(t, s)

        if len(s) - len(t) > 1 or s == t:
            return False

        i = j = 0
        while i < len(s) and j < len(t):
            if s[i] != t[j]:
                return s[i + 1:] == t[j + 1:] or s[i:] == t[j + 1:]
            i += 1
            j += 1

        return len(t) == j + 1
