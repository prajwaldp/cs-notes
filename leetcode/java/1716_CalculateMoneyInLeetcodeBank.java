class Solution {
  public int totalMoney(int n) {
    int sum = 0;
    int start = 0;
    for (int i = 0; i < n; i++) {
        if (i % 7 == 0) {
            start++;
        }

        sum += start + (i % 7);
    }

    return sum;
  }
}