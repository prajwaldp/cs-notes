class Solution {
  public int compress(char[] chars) {
    int i = 0;  // read head
    int j = 0;  // write head
    int n = chars.length;

    while (i < n) {
      char ch = chars[i];
      int count = 1;

      while (i + 1 < n && chars[i + 1] == ch) {
        i++;
        count++;
      }

      // i points to the last repeated character
      i++;

      chars[j++] = ch;
      if (count > 1) {
        for (char c: String.valueOf(count).toCharArray()) {
          chars[j++] = c;
        }
      }
    }
    return j;
  }
}
