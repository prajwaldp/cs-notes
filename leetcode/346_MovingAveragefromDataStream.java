class MovingAverage {
  private Deque<Integer> elements;
  private int size;
  private double sum;

  public MovingAverage(int size) {
    this.size = size;
    this.elements = new ArrayDeque<>();
    this.sum = 0.0;
  }

  public double next(int val) {
    elements.addLast(val);
    sum += val;

    if (elements.size() == size + 1) {
      sum -= elements.removeFirst();
      return sum / this.size;
    }

    return sum / elements.size();
  }
}