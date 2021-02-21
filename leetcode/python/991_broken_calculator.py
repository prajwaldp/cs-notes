class Solution:
    def brokenCalc(self, x, y):
        res = 0
        while x < y:
            y = y + 1 if y % 2 == 1 else y // 2
            res += 1
        return res + x - y
