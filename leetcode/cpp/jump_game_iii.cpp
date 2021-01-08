class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        queue<int> q;
        unordered_set<int> seen;
        q.push(start);

        while (!q.empty()) {
            int next = q.front(); q.pop();
            if (arr[next] == 0) return true;
            
            if (seen.find(next) != seen.end() || next < 0 || next >= arr.size()) continue;
            seen.insert(next);
            
            if (next + arr[next] < arr.size()) q.push(next + arr[next]);
            if (next - arr[next] >= 0) q.push(next - arr[next]);
        }

        return false;
    }
};
