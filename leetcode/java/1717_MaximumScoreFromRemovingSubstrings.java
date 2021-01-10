/*
Why greedy works?
-----------------
Suppose ab > ba

1) ....aabb....
2) ....aaba....
3) ....baba....
4) ....babb....

In cases 1 and 2, we can get only ab's
In case 3, we can get ab + ba or ba + ba. ab + ba is better.
In case 4, we can get ba or ab. ab is better

Therefore, greedy works
*/

class Solution {
  public int maximumGain(String s, int x, int y) {
    char prev, curr;
    int mn, mx;
    if (x > y) {
      prev = 'a';
      curr = 'b';
      mn = y;
      mx = x;
    } else {
      prev = 'b';
      curr = 'a';
      mn = x;
      mx = y;
    }

    Deque<Character> stack1 = new ArrayDeque<>();
    Deque<Character> stack2 = new ArrayDeque<>();
    int score = 0;

    for (int i = 0; i < s.length(); i++) {
      if (!stack1.isEmpty() && stack1.getFirst() == prev && s.charAt(i) == curr) {
        stack1.removeFirst();
        score += mx;
      } else {
        stack1.addFirst(s.charAt(i));
      }
    }

    while (!stack1.isEmpty()) {
      char last = stack1.removeFirst();
      if (!stack2.isEmpty() && stack2.getFirst() == prev && last == curr) {
        stack2.removeFirst();
        score += mn;
      } else {
        stack2.addFirst(last);
      }
    }

    return score;
  }
}

/*
[a, a, b, b, k, b, b, b, f, v, y, b, s, s, b, t, a, o, a, a, a, t, a, a, a, d, a, b, b, b, m, a, k, g, a, b, o, a, p, b, b, b, b, o, a, b, v, q, h, b, b, z, b, b, k, a, p, a, a, v, b, b, e, g, h, a, c, a, m, d, p, a, a, q, b, q, a, b, b, j, b, m, k, a, j, a, s, a, a, b, b, w, a, b, r, b, f, u, y, a, a, z, b, h, a]
[a, h, b, z, a, a, y, u, f, b, r, b, a, w, b, b, a, a, s, a, j, a, k, m, b, j, b, b, a, q, b, q, a, a, p, d, m, a, c, a, h, g, e, b, b, v, a, a, p, a, k, b, b, z, b, b, h, q, v, b, a, o, b, b, b, b, p, a, o, b, a, g, k, a, m, b, b, b, a, d, a, a, a, t, a, a, a, o, a, t, b, s, s, b, y, v, f, b, b, b, k, b, b, a, a]
*/