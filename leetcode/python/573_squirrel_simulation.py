class Solution:
    def minDistance(self, height, width, tree_pos, squirrel_pos, nut_positions):
        sum_, max_squirrel_to_nut_dist = 0, -1
        for nut_pos in nut_positions:
            # Compute the Manhattan distance
            dist = abs(tree_pos[0] - nut_pos[0]) + abs(tree_pos[1] - nut_pos[1])
            sum_ += 2 * dist
            max_squirrel_to_nut_dist = max(max_squirrel_to_nut_dist,
                                           dist - abs(squirrel_pos[0] - nut_pos[0]) - abs(squirrel_pos[1] - nut_pos[1]))

        return sum_ - max_squirel_to_nut_dist
