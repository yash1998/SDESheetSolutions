package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level;
        boolean direction = true;  // false- left, true- right;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int n = que.size();
            level = new ArrayList<>();
            for(int i=0; i<n; i++) {
                TreeNode curr = que.poll();
                level.add(curr.val);
                if (curr.left != null) que.offer(curr.left);
                if (curr.right != null) que.offer(curr.right);
            }
            if (!direction) Collections.reverse(level);
            result.add(level);
            direction ^= true;
        }

        return result;
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
