class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Deque<List<String>> q = new ArrayDeque<>();
    q.addLast(new ArrayList<>());
    q.getLast().add(beginWord);

    List<List<String>> ans = new ArrayList<>();
    Set<String> wordSet = new HashSet<>();
    wordSet.addAll(wordList);

    if (!wordSet.contains(endWord)) {
      return ans;
    }

    int minTransformationsReq = Integer.MAX_VALUE;
    int level = 1;
    Set<String> visited = new HashSet<>();

    while (!q.isEmpty()) {
      List<String> path = q.removeFirst();

      if (path.size() > level) {
        for (String w : visited) {
          wordSet.remove(w);
        }
        visited.clear();
        if (path.size() > minTransformationsReq) {
          break;
        }
        level = path.size();
      }

      String lastWord = path.get(path.size() - 1);
      char[] chs = lastWord.toCharArray();
      for (int i = 0; i < chs.length; i++) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          if (ch == chs[i]) {
            continue;
          }
          char old = chs[i];
          chs[i] = ch;
          String nextWord = String.valueOf(chs);
          if (wordSet.contains(nextWord)) {
            visited.add(nextWord);
            List<String> newPath = new ArrayList<>();
            newPath.addAll(path);
            newPath.add(nextWord);
            if (nextWord.equals(endWord)) {
              minTransformationsReq = level;
              ans.add(newPath);
            } else {
              q.addLast(newPath);
            }
          }
          chs[i] = old;
        }
      }
    }
    return ans;
  }
}
