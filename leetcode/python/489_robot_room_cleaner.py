# """
# This is the robot's control interface.
# You should not implement it, or speculate about its implementation
# """
# class Robot:
#    def move(self):
#        """
#        Returns true if the cell in front is open and robot moves into the cell.
#        Returns false if the cell in front is blocked and robot stays in the current cell.
#        :rtype bool
#        """
#
#    def turnLeft(self):
#        """
#        Robot will stay in the same cell after calling turnLeft/turnRight.
#        Each turn will be 90 degrees.
#        :rtype void
#        """
#
#    def turnRight(self):
#        """
#        Robot will stay in the same cell after calling turnLeft/turnRight.
#        Each turn will be 90 degrees.
#        :rtype void
#        """
#
#    def clean(self):
#        """
#        Clean the current cell.
#        :rtype void
#        """

class Solution:
    def cleanRoom(self, robot):
        DIRECTIONS = ((0, 1), (-1, 0), (0, -1), (1, 0))

        def backtrack(i, j):
            nonlocal curr_dir
            if (i, j) in done:
                return

            robot.clean()
            done.add((i, j))

            for _ in range(4):  # try 4 times (all 4 directions)
                if robot.move():
                    next_i = i + DIRECTIONS[curr_dir][0]
                    next_j = j + DIRECTIONS[curr_dir][1]
                    backtrack(next_i, next_j)

                    # Reset state after the call to backtrack
                    robot.turnLeft()
                    robot.turnLeft()
                    robot.move()
                    robot.turnLeft()
                    robot.turnLeft()

                # The robot is on (i, j) now
                robot.turnRight()
                curr_dir = (curr_dir + 1) % 4

        done = set()
        curr_dir = 0
        backtrack(0, 0)
