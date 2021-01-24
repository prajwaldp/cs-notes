from typing import List

class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        highest = curr = 0
        for i in gain:
            curr += i
            highest = max(highest, curr)
        return highest
