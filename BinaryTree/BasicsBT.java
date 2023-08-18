package BinaryTree;

public class BasicsBT {

    // height
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // check tree is height balanced/not
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        return Math.max(left, right) +1;
    }

    // Diameter
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }

    int result = 0;

    public int solve(TreeNode root) {
        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);
        result = Math.max(result, left+right);
        return Math.max(left, right)+1;
    }

    // Max Path Sum
    // int result = 0;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        solve1(root);
        return result;
    }

    public int solve1(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, solve1(root.left));
        int right = Math.max(0, solve1(root.right));

        result = Math.max(result, root.val+left+right);
        return root.val+Math.max(left,right);
    }

    // Check identical trees
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p== null && q == null) return true;
        if (p== null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
