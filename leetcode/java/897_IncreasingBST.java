class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyHead = new TreeNode(-1);
        TreeNode curr = dummyHead;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }

            curr.right = stack.removeFirst();
            curr = curr.right;
            curr.left = null;

            if (curr.right != null) {
                root = curr.right;
            }
        }

        return dummyHead.right;
    }

    // Recursive version

    TreeNode curr;

    public TreeNode increasingBSTRecursive(TreeNode root) {
        TreeNode ans = new TreeNode();
        curr = ans;
        inorder(root);
        return ans.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        curr.right = root;
        curr = curr.right;
        curr.left = null;
        inorder(root.right);
    }
}