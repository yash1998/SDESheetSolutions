package BinaryTree;

public class LCA {


    // assumptions
    // 1. no dupes
    // 2. both exist
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // searching the node
        if (root.equals(p) || root.equals(q))
            return root;

        // preorder, checking which one exist
        TreeNode lcaLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode lcaRight = lowestCommonAncestor(root.right, p, q);

        // if both exist in diff subtrees
        if (lcaLeft != null && lcaRight != null)
            return root;
        if (lcaLeft != null)
            return lcaLeft;
        return lcaRight;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
