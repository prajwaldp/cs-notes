class Solution:
    def minAvailableDuration(self, slots1: List[List[int]], slots2: List[List[int]], duration: int) -> List[int]:
        slots1.sort()
        slots2.sort()

        i = j = 0
        n1, n2 = len(slots1), len(slots2)
        while i < n1 and j < n2:
            intersect_start = max(slots1[i][0], slots2[j][0])
            intersect_end = min(slots1[i][1], slots2[j][1])

            if intersect_start + duration <= intersect_end:
                return [intersect_start, intersect_start + duration]
            elif slots1[i][1] < slots2[j][1]:
                i += 1
            else:
                j += 1

        return []
