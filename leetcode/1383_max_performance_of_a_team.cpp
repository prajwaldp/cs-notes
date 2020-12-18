#include <vector>
#include <queue>
#include <iostream>

/*
 * sum(s) * min(e)
 * [0 .... k - 1 k ... n - 1
 * |-----A------|-----B----|
 * |-----------C-----------|
 * let A = 0 .... k - 1 be sorted by speed (we should remove the smallest speed if needed)
 * let B = k .... n - 1 be sorted by efficiency (decreasing),
 *      and efficiency(a) >= efficiency(b) for all a in A and b in B
 */

using namespace std;

int maxPerformance(int n, vector<int>& s, vector<int>& e, int k) {
    vector<pair<int, int>> a;
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 0; i < n; i++)
        a.push_back({ s[i], e[i] });

    auto cmp = [](auto& a, auto& b) { return a.second > b.second; };
    sort(a.begin(), a.end(), cmp); // sort in decreasing order of effeciency

    long ans = 0;
    long aggSpeed = 0;
 
    for (auto& [s, e]: a) {
        pq.push(s);
        aggSpeed += s;
        
        if (pq.size() > k) {
            aggSpeed -= pq.top(); // remove the smallest speed
            pq.pop();
        }
        
        ans = max(ans, aggSpeed * e);
    }
    return ans % (int)(1e9 + 7);
}

int main() {
    vector<int> s {2, 10, 3, 1, 5, 8};
    vector<int> e {5, 4, 3, 7, 9, 2};
    cout << maxPerformance(6, s, e, 2);
    return 0;
}
