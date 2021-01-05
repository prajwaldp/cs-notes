class Solution {
  public int minMeetingRooms(int[][] intervals) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Arrays.sort(intervals, (a, b) -> {
      return Integer.compare(a[0], b[0]);
    });
    int minRoomsReq = 0;
    for (int[] interval: intervals) {
      while (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
        minHeap.poll();
      }
      minHeap.offer(interval[1]);
      minRoomsReq = Math.max(minRoomsReq, minHeap.size());
    }
    return minRoomsReq;
  }

  public int minMeetingRoomsAlt(int[][] intervals) {
    int n = intervals.length;
    int[] startTimes = new int[n];
    int[] endTimes = new int[n];
    for (int i = 0; i < n; i++) {
      startTimes[i] = intervals[i][0];
      endTimes[i] = intervals[i][1];
    }
    Arrays.sort(startTimes);
    Arrays.sort(endTimes);

    int minRoomsReq = 0;
    int currentMeeting = 0;

    for (int start: startTimes) {
      if (start < endTimes[currentMeeting]) {
        minRoomsReq++;
      } else {
        currentMeeting++;
      }
    }

    return minRoomsReq;
  }
}
