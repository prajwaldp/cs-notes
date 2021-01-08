class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Deque<String> q = new ArrayDeque<>();
    q.addLast(beginWord);

    Set<String> explored = new HashSet<>();
    explored.add(beginWord);

    Set<String> wordListSet = new HashSet<>();
    wordListSet.addAll(wordList);

    int level = 1;

    while (!q.isEmpty()) {
      int qsize = q.size();
      while (qsize-- > 0) {
        String next = q.removeFirst();
        if (next.compareTo(endWord) == 0) {
          return level;
        }
        StringBuilder wordBuilder = new StringBuilder(next);
        for (int i = 0; i < next.length(); i++) {
          for (char sub = 'a'; sub <= 'z'; sub++) {
            if (sub == next.charAt(i)) {
              continue;
            }
            wordBuilder.setCharAt(i, sub);
            String candidateWord = wordBuilder.toString();
            if (wordListSet.contains(candidateWord) && !explored.contains(candidateWord)) {
              explored.add(candidateWord);
              q.addLast(candidateWord);
            }
          }
          wordBuilder.setCharAt(i, next.charAt(i));
        }
      }
      level++;
    }
    return 0;
  }
}

class SolutionAlt {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();

    beginSet.add(beginWord);
    endSet.add(endWord);

    int level = 1;
    Set<String> visited = new HashSet<>();
    Set<String> wordListSet = new HashSet<>();
    wordListSet.addAll(wordList);

    if (!wordListSet.contains(endWord)) {
      return 0;
    }

    while (!beginSet.isEmpty() && !endSet.isEmpty()) {

      if (beginSet.size() > endSet.size()) {
        Set<String> beginSetCopy = beginSet;
        beginSet = endSet;
        endSet = beginSetCopy;
      }

      Set<String> temp = new HashSet<String>();

      for (String word: beginSet) {
        char[] chs = word.toCharArray();

        for (int i = 0; i < chs.length; i++) {
          for (char sub = 'a'; sub <= 'z'; sub++) {
            if (sub != chs[i]) {
              chs[i] = sub;

              String target = String.valueOf(chs);
              if (endSet.contains(target)) {
                return level + 1;
              }
              if (!visited.contains(target) && wordListSet.contains(target)) {
                temp.add(target);
                visited.add(target);
              }

              chs[i] = word.charAt(i);
            }
          }
        }
      }

      level++;
      beginSet = temp;
    }

    return 0;
  }
}