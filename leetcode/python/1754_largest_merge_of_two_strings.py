class Solution:
    # 1852ms
    def largestMerge(self, word1, word2):
        m, n = len(word1), len(word2)
        i = j = 0
        ans = []
        while i < m and j < n:
            if word1[i] < word2[j]:
                ans.append(word2[j])
                j += 1
            elif word1[i] > word2[j]:
                ans.append(word1[i])
                i += 1
            else:
                ii, jj = i, j
                while ii < m and jj < n and word1[ii] == word2[jj]:
                    ii += 1
                    jj += 1

                if ii == m:
                    ans.append(word2[j])
                    j += 1

                elif jj == n:
                    ans.append(word1[i])
                    i += 1

                elif word1[ii] > word2[jj]:
                    ans.append(word1[i])
                    i += 1

                elif word1[ii] < word2[jj]:
                    ans.append(word2[j])
                    j += 1

        while i < m:
            ans.append(word1[i])
            i += 1

        while j < n:
            ans.append(word2[j])
            j += 1

        return ''.join(ans)

    # 88ms
    def largestMergeAlt(self, word1, word2):
        m, n = len(word1), len(word2)
        i = j = 0
        ans = []
        while i < m and j < n:
            if word1[i:] > word2[j:]:
                ans.append(word1[i])
                i += 1
            else:
                ans.append(word2[j])
                j += 1

        ans.append(word1[i:])
        ans.append(word2[j:])

        return ''.join(ans)
