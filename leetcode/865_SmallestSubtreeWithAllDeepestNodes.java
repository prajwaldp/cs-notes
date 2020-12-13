class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        Map<TreeNode, Integer> depths = new HashMap<>();
        depth(root, depths);
        return dfs(root, depths);
    }

    private TreeNode depth(TreeNode root, Map<TreeNode, Integer> depths) {
        if (root == null) return 0;
        if (depths.containsKey(root)) return depths.get(root);
        int m = Math.max(depth(root.left, depths), depth(root.right, depths)) + 1;
        depths.put(root, m);
        return m;
    }

    private TreeNode dfs(TreeNode root, Map<TreeNode, Integer> depths) {
        int left = depth(root.left, depths);
        int right = depth(root.right, depths);
        if (left == right) return root;
        if (left > right) return dfs(root.left, depths);
        return dfs(root.right, depths);
    }
}

