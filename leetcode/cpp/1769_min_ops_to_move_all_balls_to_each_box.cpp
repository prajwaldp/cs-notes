class Solution {
public:
    vector<int> minOperations(string boxes) {
        int n = boxes.size();
        vector<int> res(n);
        for (int i = 0, ops = 0, count = 0; i < n; i++) {
            res[i] += ops;
            count += boxes[i] - '0';
            ops += count;
        }
        for (int i = n - 1, ops = 0, count = 0; i >= 0; i--) {
            res[i] += ops;
            count += boxes[i] - '0';
            ops += count;
        }
        return res;
    }
};

