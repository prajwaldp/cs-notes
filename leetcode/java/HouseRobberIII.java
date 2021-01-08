public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        // Option 1 - rob the root
        int rob1 = root.val;
        if (root.left != null) rob1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) rob1 += rob(root.right.left) + rob(root.right.right);

        // Option 2 - rob the children
        int rob2 = rob(root.left) + rob(root.right);

        return Math.max(rob1, rob2);
    }
}
