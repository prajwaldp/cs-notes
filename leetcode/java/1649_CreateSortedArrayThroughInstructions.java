// Times out, O(n^2)
class Solution {
  public int createSortedArray(int[] instructions) {
    final int MOD = (int)1e9 + 7;
    int n = instructions.length;
    List<Integer> sorted = new ArrayList<>();
    int cost = 0;

    for (int i = 0; i < n; i++) {
      int mn = lowerBound(sorted, instructions[i]);
      int mx = upperBound(sorted, instructions[i]);
      sorted.add(mn, instructions[i]);
      cost = (cost + Math.min(mn, i - mx)) % MOD;
    }

    return cost;
  }

  private int lowerBound(List<Integer> sorted, int target) {
    int lo = 0;
    int hi = sorted.size();

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (sorted.get(mid) >= target) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  private int upperBound(List<Integer> sorted, int target) {
    int lo = 0;
    int hi = sorted.size();

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (sorted.get(mid) > target) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }
}

class SolutionAlt {
  int[] prefixSums;
  public int createSortedArray(int[] instructions) {
    final int MOD = (int)1e9 + 7;
    prefixSums = new int[100001];
    
    int n = instructions.length;
    int cost = 0;
    
    for (int i = 0; i < n; i++) {
      int inst = instructions[i];
      cost = (cost + Math.min(computeSum(inst - 1), i - computeSum(inst))) % MOD;
      updatePrefixSums(inst);
    }
    
    return cost;
  }
  
  public int computeSum(int val) {
    int sum = 0;
    while (val > 0) {
      sum += prefixSums[val];
      val -= val & -val;  // Flip the last set bit
    }
    return sum;
  }
  
  public void updatePrefixSums(int val) {
    while (val < 100001) {
      prefixSums[val]++;
      val += val & -val;  // Add the last set bit
    }
  }
}