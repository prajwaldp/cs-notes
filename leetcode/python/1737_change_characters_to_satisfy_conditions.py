class Solution:
    def minCharacters(self, a, b):
        def change(a, b):
            ans = 2**31 - 1
            for i in range(1, 26):
                count = 0

                for ch in a:
                    if ord(ch) - 97 >= i:
                        count += 1

                for ch in b:
                    if ord(ch) - 97 < i:
                        count += 1

                ans = min(ans, count)

            return ans

        ans1 = change(a, b)
        ans2 = change(b, a)

        count = Counter(a) + Counter(b)
        ans3 = len(a) + len(b) - max(count.values())
        return min(ans1, ans2, ans3)
