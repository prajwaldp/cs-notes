"""
Key Idea
========

Consider 3 cars: A, B, and C
POS[A] < POS[B] < POS[C] and SPEED[A] > SPEED[B] > SPEED[C]
If A catches upto B, but B has already caught up to C, A actually has caught up with C
"""

from typing import List


class Solution:
    def getCollisionTimes(self, cars: List[List[int]]) -> List[float]:
        n, stack = len(cars), []
        collision_times = [-1] * n

        for i in range(n - 1, -1, -1):
            pos1, speed1 = cars[i]

            # The stack stores (the indices of) all the cars that cars[i]
            # can potentially catch up to.
            # But we have to find that car C for the car A (from the A, B, C example)
            while stack:
                j = stack[-1]
                pos2, speed2 = cars[j]
                if speed1 <= speed2:
                    stack.pop()
                    continue

                collision_time = (pos2 - pos1) / (speed1 - speed2)
                if collision_time >= collision_times[j] and collision_times[j] != -1:
                    stack.pop()
                else:
                    # If cars[i] cannot catch up to cars[j]
                    break

            if stack:
                j = stack[-1]
                pos2, speed2 = cars[j]
                collision_times[i] = (pos2 - pos1) / (speed1 - speed2)

            stack.append(i)

        return collision_times
