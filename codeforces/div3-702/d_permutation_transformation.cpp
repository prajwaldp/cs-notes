#include <iostream>
#include <math.h>

typedef long long int int64;

#define ll long long

using namespace std;

void solve(int *A, int *B, int L, int R, int d) {
    if (L > R)
        return;

    int max_val = A[L], max_idx = L;
    for (int i = L + 1; i <= R; i++) {
        if (A[i] > max_val) {
            max_val = A[i];
            max_idx = i;
        }
    }

    B[max_idx] = d;
    solve(A, B, L, max_idx - 1, d + 1);
    solve(A, B, max_idx + 1, R, d + 1);
}

void solve() {
    int n;
    int A[100];
    int B[100];

    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> A[i];

    solve(A, B, 0, n - 1, 0);

    for (int i = 0; i < n; i++) {
        cout << B[i];
        if (i != n) {
            cout << " ";
        }
    }
    cout << "\n";
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
