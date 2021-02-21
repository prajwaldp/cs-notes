#include <vector>

using namespace std;

typedef vector<vector<int>> vvi;
typedef vector<int> vi;

class Solution {
  public:
    bool canChoose(vvi &groups, vi &nums) {
        int i = 0;
        for (vi &group : groups) {
            bool done = false;
            for (int j = i; j < nums.size(); j++) {
                int k = 0, jj = j;
                while (k < group.size() && nums[jj] == group[k]) {
                    k++;
                    jj++;
                }

                if (k == group.size()) {
                    i = jj;
                    done = true;
                    break;
                }
            }

            if (!done) {
                return false;
            }
        }

        return true;
    }
};
