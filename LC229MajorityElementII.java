import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int cand1 = -1, cand2 = -1, count1 = 0, count2 = 0;

    for (int n : nums) {
      if (n == cand1) {
        count1++;
      } else if (n == cand2) {
        count2++;
      } else if (count1 == 0) {
        cand1 = n;
        count1 = 1;
      } else if (count2 == 0) {
        cand2 = n;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }

    count1 = 0;
    count2 = 0;
    for (int n : nums) {
      if (n == cand1) {
        count1++;
      } else if (n == cand2) {
        count2++;
      }
    }

    List<Integer> res = new ArrayList<>();
    if (count1 > nums.length / 3)
      res.add(cand1);
    if (count2 > nums.length / 3)
      res.add(cand2);

    return res;
  }
}

class Runner {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    Solution solution = new Solution();
    int numTestCases = Integer.parseInt(br.readLine());
    while (--numTestCases >= 0) {
      int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
      solution.majorityElement(nums);
    }
  }
}
