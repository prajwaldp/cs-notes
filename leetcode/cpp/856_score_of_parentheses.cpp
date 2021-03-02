#include <stack>
#include <string>

using namespace std;

class Solution {
  public:
    int scoreOfParentheses(string s) {
        stack<int> stk;
        stk.push(0);
        for (char c : s) {
            if (c == '(')
                stk.push(0);
            else {
                int top = stk.top();
                stk.pop();
                stk.top() += (top == 0 ? 1 : 2 * top);
            }
        }
        return stk.top();
    }
};
