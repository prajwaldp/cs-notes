#include <vector>
#include <queue>

using namespace std;

class Solution
{
public:
    int minimumDeviation(vector<int> &nums)
    {
        priority_queue<int, vector<int>, greater<int>> pq;
        int mn = INT_MAX;
        for (int num : nums)
        {
            if (num % 2 == 0)
            {
                pq.push(num);
                mn = min(mn, num);
            }
            else
            {
                pq.push(num * 2);
                mn = min(mn, num * 2);
            }
        }

        int ans = INT_MAX;
        while (!pq.empty())
        {
            int curr = pq.top();
            pq.pop();
            ans = min(ans, curr - mn);

            if (curr % 2 != 0)
                break;

            pq.push(curr / 2);
            mn = min(mn, curr / 2);
        }

        return ans;
    }
};
