class Solution {
  public int findKthLargest(int[] nums, int k) {
    k = nums.length - k; // Find element at index nums.length - k in the sorted version instead
    int lo = 0;
    int hi = nums.length - 1;
    shuffle(nums);
    while (lo < hi) {
      final int j = partition(nums, lo, hi);
      if (j < k) {
        lo = j + 1;
      } else if (j > k) {
        hi = j - 1;
      } else {
        break;
      }
    }
    return nums[k];
  }

  // Shuffle to make it O(n) average time
  private void shuffle(int[] nums) {
    final Random rnd = new Random();
    for (int i = 1; i < nums.length; i++) {
      final int r = rnd.nextInt(i + 1);
      swap(nums, i, r);
    }
  }

  private int partition(int[] nums, int lo, int hi) {
    return partitionV1(nums, lo, hi);
  }

  // Hoare's partioning scheme (more efficient)
  private int partitionV1(int[] nums, int lo, int hi) {
    int pivot = nums[lo];
    int i = lo;
    int j = hi + 1;
    while (true) {
      do {
        i++;
      } while (i < hi && nums[i] < pivot);
      do {
        j--;
      } while (j > lo && nums[j] > pivot);
      if (i >= j) {
        break;
      }
      swap(nums, i, j);
    }
    swap(nums, lo, j);
    return j;
  }

  // A more intuitive version of Hoare's partitioning algorithm
  private int partitionV2(int[] nums, int lo, int hi) {
    int i = lo;
    int j = hi;
    while (i < j) {
      while (i < j && nums[i] < nums[j]) {
        i++;
      }
      if (i < j) {
        swap(nums, i, j);
        j--;
      }

      while (i < j && nums[i] < nums[j]) {
        j--;
      }
      if (i < j) {
        swap(nums, i, j);
        i++;
      }
    }

    // i and j are equal at this point
    assert i == j
    return j; // or return i
  }

  // A simpler partition algorithm ("Lomuto's partitioning")
  private int partitionV3(int[] nums, int lo, int hi) {
    int pivot = nums[hi];
    int i = lo;
    for (int j = lo; j < hi; j++) {
      if (nums[j] <= pivot) {
        swap(nums, i, j);
        i++;
      }
    }
    swap(nums, i, hi);
    return i;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
