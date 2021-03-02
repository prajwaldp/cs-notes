class Solution {
public:
    string findLongestWord(string s, vector<string>& d) {
        string longest = "";
        for (auto& w: d) {
            int i = 0;
            for (char c: s) {
                if (i < w.size() && c == w[i]) i++;
            }

            if (i == w.size() && (w.size() > longest.size() ||
                    (w.size() == longest.size() && w < longest))) {
                longest = w;
            }
        }
        return longest;
    }
};

