class Solution {
  public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
    boolean shipsInCurrRect = sea.hasShips(topRight, bottomLeft);

    if (!shipsInCurrRect) {
      return 0;
    }

    int xmin = bottomLeft[0];
    int ymin = bottomLeft[1];
    int xmax = topRight[0];
    int ymax = topRight[1];

    if (xmax == xmin && ymax == ymin) {
      return 1;
    }

    int xmid = (xmin + xmax) / 2;
    int ymid = (ymin + ymax) / 2;

    return countShips(sea, new int[] { xmid, ymid }, new int[] { xmin, ymin } ) +
        countShips(sea, new int[] { xmax, ymid }, new int[] { xmid + 1, ymin } ) +
        countShips(sea, new int[] { xmid, ymax }, new int[] { xmin, ymid + 1 }) +
        countShips(sea, new int[] { xmax, ymax }, new int[] { xmid + 1, ymid + 1 });
  }
}