package BinaryTree;

public class CountNodesInCompleteBT {
    public static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        int lh = getHeightLeft(root.left);
        int rh = getHeightRight(root.right);
        if (lh == rh)
            return ((2 << lh) - 1);
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int getHeightLeft(BinaryTreeNode<Integer> root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public static int getHeightRight(BinaryTreeNode<Integer> root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };
}
