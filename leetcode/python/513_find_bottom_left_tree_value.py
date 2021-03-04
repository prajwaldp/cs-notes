# Soln 1: BFS
class Solution:
    def findBottomLeftValue(self, root) -> int:
        q = [root]
        leftmost_val = 0

        while q:
            leftmost_val = q[0].val
            next_q = []

            for node in q:
                if node.left:
                    next_q.append(node.left)
                if node.right:
                    next_q.append(node.right)

            q = next_q

        return leftmost_val


# Soln 2: right-to-left BFS.
class Solution:
    def findBottomLeftValue(self, root):
        q = [root]
        for node in q:
            q += [c for c in [node.right, node.left] if c]
        return node.val


# Soln 3: DFS
class Solution:
    def findBottomLeftValue(self, root) -> int:

        def dfs(root, level):
            nonlocal curr_level, leftmost

            if not root:
                return

            if level > curr_level:
                curr_level = level
                leftmost = root.val

            dfs(root.left, level + 1)
            dfs(root.right, level + 1)

        curr_level = 0
        leftmost = root.val

        dfs(root, 0)
        return leftmost
