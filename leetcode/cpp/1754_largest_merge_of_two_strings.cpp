class Solution {
  public:
    string largestMerge(string word1, string word2) {
        int i = 0, j = 0, m = word1.size(), n = word2.size();

        vector<char> ans;
        while (i < m && j < n) {
            int ii = i, jj = j;

            while (ii < m && jj < n && word1[ii] == word2[jj]) {
                ii += 1;
                jj += 1;
            }

            if (ii == m) {
                ans.push_back(word2[j++]);
            }

            else if (jj == n) {
                ans.push_back(word1[i++]);
            }

            else if (word1[ii] > word2[jj]) {
                ans.push_back(word1[i++]);
            }

            else if (word1[ii] < word2[jj]) {
                ans.push_back(word2[j++]);
            }
        }

        while (i < m) {
            ans.push_back(word1[i++]);
        }

        while (j < n) {
            ans.push_back(word2[j++]);
        }

        string s;
        transform(ans.begin(), ans.end(), back_inserter(s),
                  [](char c) { return c; });

        return s;
    }
};