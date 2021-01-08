/*
When you see a closing square bracket ]
currttr = strstack.pop + intstack.pop * currstr
 */

class Solution {
  public String decodeString(String s) {
    int repeatFactor = 0;
    StringBuilder sb = new StringBuilder();

    Deque<Integer> intStack = new ArrayDeque<>();
    Deque<String> strStack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '[') {
        intStack.addFirst(repeatFactor);
        strStack.addFirst(sb.toString());

        repeatFactor = 0;
        sb = new StringBuilder();
      } else if (ch == ']') {
        int count = intStack.pop();
        String prev = strStack.pop();
        String curr = sb.toString();
        for (int j = 1; j < count; j++) {
          sb.insert(0, curr);
        }
        sb.insert(0, prev);

      } else if (Character.isDigit(ch)) {
        repeatFactor = 10 * repeatFactor + (ch - '0');
      } else {
        sb.append(ch);
      }
    }

    return sb.toString();
  }
}
