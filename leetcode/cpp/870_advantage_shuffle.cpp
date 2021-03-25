class Solution {
public:
    vector<int> advantageCount(vector<int>& A, vector<int>& B) {
        int n = A.size();
        vector<int> order(n);
        vector<int> ans(n, -1);

        for (int i = 0; i < n; i++)
            order[i] = i;

        sort(order.begin(), order.end(), [&B](int a, int b) {
            return B[a] > B[b];
        });

        sort(A.begin(), A.end(), greater<int>());

        int i = 0, j = n - 1;
        for (int ix: order)
            ans[ix] = A[i] > B[ix] ? A[i++] : A[j--];

        return ans;
    }
};
