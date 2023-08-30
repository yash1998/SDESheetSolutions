package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public static boolean isLeafNode(TreeNode curr) {
        return curr.left == null && curr.right == null;
    }

    public static void left(TreeNode curr, List<Integer> result) {
        while (curr != null && !isLeafNode(curr)) {
            result.add(curr.data);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void right(TreeNode curr, List<Integer> right) {
        while (curr != null && !isLeafNode(curr)) {
            right.add(0, curr.data);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }

    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        result.add(root.data);

        left(root.left, result);

        inorder(root, result);

        List<Integer> right = new ArrayList<>();
        right(root.right, right);

        result.addAll(right);

        return result;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        if (isLeafNode(root)) {
            res.add(root.data);
            return;
        }

        inorder(root.left, res);
        inorder(root.right, res);
    }

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
