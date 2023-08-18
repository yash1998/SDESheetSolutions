package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsToLeaf {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> result = new ArrayList<>();
        solve(root, result, "");
        return result;
    }

    public static void solve(BinaryTreeNode root, List<String> result, String sb) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            result.add(sb + root.data);
            return;
        }
        sb += root.data + " ";

        solve(root.left, result, sb);
        solve(root.right, result, sb);
    }

    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    };

}
