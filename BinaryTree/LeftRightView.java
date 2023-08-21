package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftRightView {

    public static void printLeftView(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int n = que.size();
            for(int i=0; i<n; i++) {
                TreeNode curr = que.poll();
                if (i==0) System.out.print(curr.val+" ");
                if (curr.left != null) que.offer(curr.left);
                if (curr.right != null) que.offer(curr.right);
            }
        }
    }

    // Right View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        levelOrderRecursive(root, result, 1);
        return result;
    }

    int maxLevel = 0;
    private void levelOrderRecursive(TreeNode root, List<Integer> result, int level){
        if(root == null) return;
        if(maxLevel < level){
            result.add(root.val);
            maxLevel = level;
        }
        levelOrderRecursive(root.right, result, level+1);
        levelOrderRecursive(root.left, result, level+1);

        // For left view recursive change
        // levelOrderRecursive(root.left, result, level+1);
        // levelOrderRecursive(root.right, result, level+1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
}
