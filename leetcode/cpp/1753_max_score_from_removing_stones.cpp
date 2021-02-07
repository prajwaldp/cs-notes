#include <bits/stdc++.h>

// Logic: always choose the greatest two numbers

class Solution {
  public:
    // 4ms, 10.6MB
    int maximumScore(int a, int b, int c) {
        if (a < b) {
            return maximumScore(b, a, c);
        }

        if (b < c) {
            return maximumScore(a, c, b);
        }

        if (a == 0 || b == 0) {
            return 0;
        }

        int count = std::max(1, b - c);
        return count + maximumScore(a - count, b - count, c);
    }

    // 76ms, 5.9MB
    int maximumScoreAlt(int a, int b, int c) {
        std::priority_queue<int> pq;
        pq.push(a);
        pq.push(b);
        pq.push(c);

        int ans = 0;

        while (true) {
            int i = pq.top();
            pq.pop();
            int j = pq.top();
            pq.pop();
            int k = pq.top();

            if (j == 0) {
                return ans;
            }

            int count = std::max(1, j - k);
            ans += count;

            pq.push(i - count);
            pq.push(j - count);
        }

        return -1;
    }
};
