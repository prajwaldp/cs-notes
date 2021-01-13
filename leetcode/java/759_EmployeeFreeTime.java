class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}


class Solution {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> flattened = new ArrayList<>();
    for (List<Interval> emp: schedule) {
      for (Interval meeting: emp) {
        flattened.add(meeting);
      }
    }
    Collections.sort(flattened, (a, b) -> {
      // Do we need to sort descending by .end?
      // [1, 2], [1, 3] and [1, 3], [1, 2] produces the same result.
      // So it's not needed
      return Integer.compare(a.start, b.start);
    });

    int endTime = flattened.get(0).end;
    List<Interval> freeSlots = new ArrayList<>();

    for (Interval i: flattened) {
      if (i.start > endTime) {
        freeSlots.add(new Interval(endTime, i.start));
      }
      endTime = Math.max(endTime, i.end);
    }

    return freeSlots;
  }
}