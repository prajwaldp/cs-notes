#include <vector>
#include <iostream>

using namespace std;

int solve(vector<int>& weights, vector<int>& values, int capacity) {
    int n = weights.size();
    int dp[capacity + 1];
    memset(dp, 0, sizeof dp);

    for (int i = 0; i < n; i++) {
        for (int c = capacity; c >= weights[i]; c--) {
            dp[c] = max(dp[c], dp[c - weights[i]] + values[i]);
        }
    }
    return dp[capacity];
}

int main(int argc, char** argv) {
    vector<int> weights {1, 2, 3}, values {1, 5, 3};
    cout << solve(weights, values, 5);
    return 0;
}

