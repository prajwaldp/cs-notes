class Solution {
    // O(n) Similar to Morris Traversal
    public void flatten(TreeNode root) {
        TreeNode iter = root;
        while (iter != null) {
            if (iter.left != null) {
                TreeNode prev = iter.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = iter.right;
                iter.right = iter.left
                iter.left = null;
            }
            iter = iter.right;
        }
    }

    // O(n^2)
    public void flattenAlt(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = null;

        TreeNode iter = root;
        while (iter.right != null) {
            iter = iter.right;
        }
        iter.right = right;
    }
}