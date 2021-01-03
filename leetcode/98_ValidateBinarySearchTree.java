class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }

            TreeNode top = stack.removeFirst();
            if (prev != null && top.val <= prev.val) {
                return false;
            }
            prev = top;
            root = top.right;
        }

        return true;
    }

    public boolean isValidBSTAlt(TreeNode root) {
        return isValidBSTAlt(root, null, null);
    }

    public boolean isValidBSTAlt(TreeNode root, Integer mn, Integer mx) {
        if (root == null) {
            return true;
        }

        if (mn != null && root.val <= mn) {
            return false;
        }

        if (mx != null && root.val >= mx) {
            return false;
        }

        return isValidBSTAlt(root.left, mn, root.val) &&
                isValidBSTAlt(root.right, root.val, mx);
    }
}
