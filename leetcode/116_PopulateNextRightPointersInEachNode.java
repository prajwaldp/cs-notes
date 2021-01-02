class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node ptr = root;
        while (ptr.left != null) {
            Node startOfLevel = ptr;

            while (ptr != null) {
                ptr.left.next = ptr.right;
                if (ptr.next != null)
                    ptr.right.next = ptr.next.left;

                ptr = ptr.next;
            }

            ptr = startOfLevel.left;
        }

        return root;
    }
}