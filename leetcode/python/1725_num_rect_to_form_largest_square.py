def count_good_rectangles(rectangles):
    largest_side = 0
    largest_count = 0
    for l, w in rectangles:
        side = min(l, w)
        if side == largest_side:
            largest_count += 1
        elif side > largest_side:
            largest_side = side
            largest_count = 1
    return largest_count


class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        return count_good_rectangles(rectangles)
