class Solution {
  private boolean done = false;
  
  public int[] constructDistancedSequence(int n) {
    int[] ret = new int[2 * n - 1];
    Arrays.fill(ret, -1);
    Set<Integer> included = new HashSet<>();
    backtrack(included, 0, n, ret);
    return ret;
  }
  
  void backtrack(Set<Integer> included, int start, int n, int[] ret) {
    if (done) {
      return;
    }

    if (included.size() == n) {
      done = true;
    }
    
    for (int i = start; i < ret.length; i++) {
      if (ret[i] == -1) {
        for (int j = n; j >= 1; j--) {
          if (!included.contains(j)) {
            if (j == 1) {
              included.add(j);
              ret[i] = 1;
              backtrack(included, i + 1, n, ret);
              
              if (done) return;
              
              included.remove(j);
              ret[i] = -1;
            } else if (i + j < ret.length && ret[i + j] == -1 ){
              included.add(j);
              ret[i] = ret[i + j] = j;
              backtrack(included, i + 1, n, ret);
              
              if (done) return;
              
              included.remove(j);
              ret[i] = ret[i + j] = -1;
            }
          }
        }
      }
    }
  }
}
