// Don't have to store playerIds in the treemap
// Just a count of players having that score is enough:

class Leaderboard {

  Map<Integer, Integer> playerToScore;
  Map<Integer, Set<Integer>> scoreToPlayers;

  public Leaderboard() {
    scoreToPlayers = new TreeMap<>(Collections.reverseOrder());
    playerToScore = new HashMap<>();
  }

  public void addScore(int playerId, int score) {
    int preScore = 0;
    if (playerToScore.containsKey(playerId)) {
      preScore = playerToScore.get(playerId);
      scoreToPlayers.get(preScore).remove(playerId);
    }

    int newScore = preScore + score;
    setScore(playerId, newScore);
  }

  public int top(int k) {
    int sum = 0;
    for (Map.Entry<Integer, Set<Integer>> entry: scoreToPlayers.entrySet()) {
      int score = entry.getKey();
      int numPlayers = entry.getValue().size();
      while (numPlayers-- > 0 && k-- > 0) {
        sum += score;
      }
      if (k == 0) {
        break;
      }
    }
    return sum;
  }

  public void reset(int playerId) {
    int currScore = playerToScore.get(playerId);
    scoreToPlayers.get(currScore).remove(playerId);
    setScore(playerId, 0);
  }

  private void setScore(int playerId, int score) {
    if (!scoreToPlayers.containsKey(score)) {
      scoreToPlayers.put(score, new HashSet<>());
    }
    scoreToPlayers.get(score).add(playerId);
    playerToScore.put(playerId, score);
  }
}
