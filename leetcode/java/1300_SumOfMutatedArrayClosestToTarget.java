class Solution {
  public int findBestValue(int[] arr, int target) {
    Arrays.sort(arr);
    int n = arr.length;
    int i = 0;
    
    for (i = 0; i < n; i++) {
      // If the remaining elements filled with arr[i] sum up to more than target
      if (arr[i] * (n - i) >= target) {
        break;
      }
      
      target -= arr[i];
    }
    
    if (i == n) {
      return arr[n - 1];
    }
    
    int res = target / (n - i);
    
    // Tricky bit
    // TODO: Add explanation
    if (target - res * (n - i) > (res + 1) * (n - i) - target) {
      return res + 1;
    }
    
    return res;
  }
}
