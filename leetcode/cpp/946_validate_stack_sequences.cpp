class Solution {
  public:
    bool validateStackSequences(vector<int> &pushed, vector<int> &popped) {
        stack<int> simulator;
        int j = 0;
        for (int i : pushed) {
            simulator.push(i);
            while (simulator.top() == popped[j]) {
                simulator.pop();
                j++;
            }
        }

        return j == popped.size();
    }
};