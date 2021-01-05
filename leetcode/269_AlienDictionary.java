/*
Watch out for the edges cases:
- ["abc", "ab"] the second string is a prefix of the first string
- when all the characters in the keyset of the graph don't appear in the ans
- ["ac","ab","zc","zb"] add all nodes with indegree = 0 to the queue initially
- cycles should be handled by the indegrees array
 */

class Solution {
  public String alienOrder(String[] words) {
    Map<Character, Set<Character>> graph = new HashMap<>();
    int[] indegrees = new int[26];

    for (String word: words) {
      for (char ch: word.toCharArray()) {
        graph.putIfAbsent(ch, new HashSet<>());
      }
    }

    for (int i = 1; i < words.length; i++) {
      String word1 = words[i - 1];
      String word2 = words[i];

      // Handle the case when word1 is a prefix of word2
      if (word1.length() > word2.length() && word1.startsWith(word2)) {
        return "";
      }

      for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
        char ch1 = word1.charAt(j);
        char ch2 = word2.charAt(j);

        if (ch1 != ch2) {
          if (!graph.get(ch1).contains(ch2)) {
            graph.get(ch1).add(ch2);
            indegrees[ch2 - 'a']++;
          }
          break;
        }
      }
    }

    Deque<Character> q = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for (char node: graph.keySet()) {
      if (indegrees[node - 'a'] == 0) {
        q.addLast(node);
      }
    }

    while (!q.isEmpty()) {
      char next = q.removeFirst();
      sb.append(next);

      for (char neighbor: graph.get(next)) {
        indegrees[neighbor - 'a']--;
        if (indegrees[neighbor - 'a'] > 0) {
          continue;
        }
        q.addLast(neighbor);
      }
    }

    return graph.size() == sb.length() ? sb.toString() : "";
  }
}