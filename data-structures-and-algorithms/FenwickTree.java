import java.util.Arrays;

// Also known as Binary Indexed Tree
class FenwickTree {
  public int n;
  public int[] fenwickSums;
  public int[] data;

  public FenwickTree(int[] data) {
    this.data = data;  // should be 1-indexed
    this.n = data.length;
    this.populate();
  }

  /**
   * Populates the Fenwick Tree in linear time;
   */
  private void populate() {
    fenwickSums = Arrays.copyOf(data, n);
    for (int i = 1; i < n; i++) {
      int parent = i + (i & -i);
      if (parent < n) {
        fenwickSums[parent] += fenwickSums[i];
      }
    }
  }

  /**
   * Computes the cumulative sum upto index i
   */
  public int sum(int i) {
    int s = 0;
    while (i > 0) {
      s += this.fenwickSums[i];
      i -= i & -i;  // flips the last set bit
    }
    return s;
  }

  /**
   * Adds `k` into data[i] and updates the fenwickSums
   */
  public void add(int i, int k) {
    while (i < fenwickSums.length) {
      fenwickSums[i] += k;
      i += i & -i;   // adds the last set bit
    }
  }
}