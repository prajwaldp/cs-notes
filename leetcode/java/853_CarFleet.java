import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // If cars are arrange like this: C1, C2, C3, C4 ... CN
        // Where C1 is ahead of C2, C2 is ahead of C3, ....
        // Calculate the time needed for each car to reach the finish
        // if timeNeeded(C2) < timeNeeded(C1) => speed of C2 > speed of C1
        // and C2 catches up to C1 at some point before the finish line
        // and C1 and C2 form a fleet
        //
        // if timeNeeded(C2) > timeNeeded(C1), C1 reaches the finish line first forming a fleet
        // C2 becomes the next slowest car that C3 ... CN can catch up to
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (x, y) -> y[0] - x[0]);
        int fleetCount = 0;
        double slowestCarTimeNeeded = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            double timeNeeded = (double)(target - cars[i][0]) / cars[i][1];
            if (timeNeeded > slowestCarTimeNeeded) {
                slowestCarTimeNeeded = timeNeeded;
                fleetCount++;
            }
        }

        return fleetCount;
    }
}

