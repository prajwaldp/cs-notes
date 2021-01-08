class HitCounter {

  private Deque<Integer> q;

  /** Initialize your data structure here. */
  public HitCounter() {
    q = new ArrayDeque<>();
  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  public void hit(int timestamp) {
    q.addLast(timestamp);
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  public int getHits(int timestamp) {
    while (!q.isEmpty() && timestamp - q.getFirst() > 300) {
      q.removeFirst();
    }
    return q.size();
  }
}

class HitCounterAlt {

  private int[] hits;
  private int[] count;

  /** Initialize your data structure here. */
  public HitCounter() {
    hits = new int[300];
    count = new int[300];
  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  public void hit(int timestamp) {
    int idx = timestamp % 300;
    if (hits[idx] == timestamp) {
      count[idx]++;
    } else {
      hits[idx] = timestamp;
      count[idx] = 1;
    }
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  public int getHits(int timestamp) {
    int idx = timestamp % 300;
    int ans = 0;
    for (int i = 0; i < 300; i++) {
      if (timestamp - hits[i] < 300) {
        ans += count[i];
      }
    }
    return ans;
  }
}
