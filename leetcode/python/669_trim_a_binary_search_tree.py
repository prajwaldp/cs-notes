class Solution:
    def trimBST(self, root, low, high):
        """
        Trims the BST rooted at `root` so that all elements lie in [low, high]
        """

        if root is None:
            return None

        if root.val < low:
            return self.trimBST(root.right, low, high)

        if root.val > high:
            return self.trimBST(root.left, low, high)

        root.left = self.trimBST(root.left, low, high)
        root.right = self.trimBST(root.right, low, high)

        return root
