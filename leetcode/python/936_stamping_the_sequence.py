class Solution:
    def movesToStamp(self, stamp, target):
        if stamp == target:
            return [0]

        stamp, target = list(stamp), list(target)
        m, n = len(stamp), len(target) - len(stamp) + 1

        ans = []
        sdiff = True
        tdiff = True

        while tdiff:
            tdiff = False
            for i in range(n):
                sdiff = False
                for j in range(m):
                    if target[i + j] == '*':
                        continue
                    if target[i + j] != stamp[j]:
                        break

                    sdiff = True

                else:
                    if sdiff:
                        tdiff = True
                        for j in range(i, i + m):
                            target[j] = '*'
                        ans.append(i)

        for i in range(len(target)):
            if target[i] != '*':
                return []

        return reversed(ans)
