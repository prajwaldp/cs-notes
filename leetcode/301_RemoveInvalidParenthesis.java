import java.util.*;

class Solution {
  public List<String> removeInvalidParentheses(String s) {
    int validStringSize = getLargestValidStringSize(s);
    StringBuilder curr = new StringBuilder();
    Set<String> resultSet = new HashSet<>();
    dfs(s, 0, 0, 0, curr, resultSet, validStringSize);
    return new ArrayList<>(resultSet);
  }

  private void dfs(String s, int pos, int leftCount, int rightCount,
                   StringBuilder curr, Set<String> res, int targetSize) {

    if (curr.length() == targetSize && leftCount == rightCount) {
      res.add(curr.toString());
    }

    if (pos == s.length() || leftCount - rightCount > targetSize - curr.length()) {
      return;
    }

    char ch = s.charAt(pos);
    // Don't include ch
    dfs(s, pos + 1, leftCount, rightCount, curr, res, targetSize);

    // Include ch
    curr.append(ch);
    if (ch == '(') {
      dfs(s, pos + 1, leftCount + 1, rightCount, curr, res, targetSize);
    } else if (ch == ')') {
      if (leftCount > rightCount) {
        dfs(s, pos + 1, leftCount, rightCount + 1, curr, res, targetSize);
      }
    } else {
      dfs(s, pos + 1, leftCount, rightCount, curr, res, targetSize);
    }
    curr.delete(curr.length() - 1, curr.length());
  }

  private int getLargestValidStringSize(String s) {
    int balance = 0;
    int toRemove = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        balance++;
      } else if (ch == ')') {
        balance--;
      }

      if (balance < 0) {
        toRemove++;
        balance = 0;
      }
    }

    return s.length() - (toRemove + balance);
  }

  public static void main(String[] args) {
    var s = new Solution();
    var op1 = s.removeInvalidParentheses("()())()");
    var op2 = s.removeInvalidParentheses("(a)())()");
    var op3 = s.removeInvalidParentheses(")(");

    System.out.println(op1);
    System.out.println(op2);
    System.out.println(op3);
  }
}