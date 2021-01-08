class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node ptr = root;  // Iterator for all the nodes
        Node nextLevelStart = null;  // While ptr works on level i (is itself on level i - 1), nextLevelStart points to the first node on level i
        Node prev = null;  // While ptr works on level i (is itself on level i - 1, prev is the last non-null node on level i)

        while (ptr != null) {
            nextLevelStart = null;
            prev = null;

            while (ptr != null) {
                if (ptr.left != null) {
                    if (nextLevelStart == null) {
                        nextLevelStart = ptr.left;
                        prev = ptr.left;
                    } else {
                        prev.next = ptr.left;
                        prev = prev.next;
                    }
                }
                if (ptr.right != null) {
                    if (nextLevelStart == null) {
                        nextLevelStart = ptr.right;
                        prev = ptr.right;
                    } else {
                        prev.next = ptr.right;
                        prev = prev.next;
                    }
                }
                ptr = ptr.next;
            }

            ptr = nextLevelStart;
        }

        return root;
    }
}