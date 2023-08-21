package BinaryTree;

import java.util.HashMap;

public class ConstructBTFromPreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return solvePre(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        
        // take postorder i/p
        // return solvePost(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public TreeNode solvePre(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2,
            HashMap<Integer, Integer> map) {
        if (s1 <= e1) {
            TreeNode root = new TreeNode(preorder[s1]);
            int i = map.get(preorder[s1]), countRight = s1 + i;
            root.left = solvePre(preorder, s1 + 1, countRight - s2, inorder, s2, i - 1, map);
            root.right = solvePre(preorder, countRight - s2 + 1, e1, inorder, i + 1, e2, map);
            return root;
        } else {
            return null;
        }
    }

    public TreeNode solvePost(int[] postorder, int s1, int e1, int[] inorder, int s2, int e2, HashMap<Integer, Integer> map) {
        if (s1 <= e1) {
            TreeNode root = new TreeNode(postorder[e1]);
            int i = map.get(postorder[e1]), countLeft = i-s2;
            root.left = solvePost(postorder, s1, s1+countLeft-1, inorder, s2, i-1, map);
            root.right = solvePost(postorder, s1+countLeft, e1-1, inorder, i+1, e2, map);
            return root;
        } else {
            return null;
        }
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
