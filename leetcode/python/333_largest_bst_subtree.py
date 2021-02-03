class Solution:
    def largestBSTSubtree(self, root):
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31

        def dfs(root):
            """
            returns min_val, max_val, count of largest bst
            """
            if root is None:
                return INT_MAX, INT_MIN, 0

            left_min, left_max, left_count = dfs(root.left)
            right_min, right_max, right_count = dfs(root.right)

            if root.val > left_max and root.val < right_min:
                return min(root.val, left_min), max(root.val, right_max), left_count + right_count + 1

            return INT_MIN, INT_MAX, max(left_count, right_count)

        _, _, root_count = dfs(root)
        return root_count
