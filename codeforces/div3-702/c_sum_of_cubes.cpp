#include <iostream>
#include <math.h>

typedef long long int int64;

#define ll long long

using namespace std;

void solve() {
    ll n, cube;
    bool pos = false;
    cin >> n;
    for (ll a = 1; (cube = a * a * a) <= n; a++) {
        ll k = n - cube;
        ll b = cbrtl(k);
        while (b * b * b < k)
            ++b;

        if (b * b * b > k)
            --b;

        if (b > 0 && b * b * b == k)
            pos = true;
    }

    cout << (pos ? "YES\n" : "NO\n");
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}