class Solution {
  static class Rectangle {
    public int x;
    public int h;

    public Rectangle(int x, int h) {
      this.x = x;
      this.h = h;
    }

    public int calcArea(int y) {
      return (y - x) * h;
    }
  }
  
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    Deque<Rectangle> stack = new ArrayDeque<>(); // monotonically increasing stack

    for (int i = 0; i <= heights.length; i++) {
      int startPos = i;
      while (!stack.isEmpty() && i == heights.length || stack.getFirst().h >= heights[i]) {
        Rectangle r = stack.removeFirst();
        maxArea = Math.max(maxArea, r.calcArea(i));
        startPos = r.x; // start position of the next rectangle
      }
      
      if (i != heights.length) {
        stack.addFirst(new Rectangle(startPos, heights[i]));  
      }
    }

    return maxArea;
  }
}