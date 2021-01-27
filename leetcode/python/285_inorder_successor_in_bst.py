class Solution:
    def inorderSuccessor(self, root, p):
        stack = []
        prev = None
        while stack or root:
            while root:
                stack.append(root)
                root = root.left

            next = stack.pop()
            if prev == p:
                return next

            prev = next

            if next.right:
                root = next.right

    def inorderSuccessorAlt(self, root, p):
        suc = None
        while root:
            if p.val < root.val:
                suc = root
                root = root.left
            else:
                root = root.right
        return suc
