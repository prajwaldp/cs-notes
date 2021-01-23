#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool closeStrings(string word1, string word2) {
	if (word1.size() != word2.size()) {
	  return false;
	}

	vector<int> count1(26), count2(26), exists1(26), exists2(26);

	for (char c: word1) {
	  count1[c - 'a']++;
	  exists1[c - 'a'] = 1;
	}

	for (char c: word2) {
	  count2[c - 'a']++;
	  exists2[c - 'a'] = 1;
	}

	sort(begin(count1), end(count1));
	sort(begin(count2), end(count2));

	return count1 == count2 && exists1 == exists2;
  }
};
