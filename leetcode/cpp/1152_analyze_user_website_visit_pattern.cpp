#include <string>
#include <vector>
#include <map>
#include <set>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Solution
{
public:
    vector<string> mostVisitedPattern(vector<string> &username,
                                      vector<int> &timestamp,
                                      vector<string> &website)
    {
        unordered_map<string, vector<string>> mp;
        unordered_map<string, int> count;
        int mCount = 0;

        string res;

        for (int i = 0; i < username.size(); i++)
        {
            mp[username[i]].push_back(website[i]);
        }

        for (auto &[username, list] : mp)
        {
            unordered_set<string> ts;
            int n = list.size();

            for (int i = 0; i < n; i++)
            {
                for (int j = i + 1; j < n; j++)
                {
                    for (int k = j + 1; k < n; k++)
                    {
                        ts.insert(list[i] + " " + list[j] + " " + list[k]);
                    }
                }
            }

            for (string s : ts)
            {
                count[s]++;
            }
        }

        for (auto &[order, times] : count)
        {
            if (times >= mCount)
            {
                res = res == "" || mCount < times ? order : min(res, order);
                mCount = times;
            }
        }

        vector<string> ret;
        size_t pos = 0;
        string token;
        while ((pos = res.find(" ")) != string::npos)
        {
            ret.push_back(res.substr(0, pos));
            res.erase(0, pos + 1);
        }
        ret.push_back(res);

        return ret;
    }
};
