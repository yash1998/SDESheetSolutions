package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SerialDeserialize {
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = que.poll();
                if (curr == null) {
                    sb.append("#,");
                    continue;
                }
                sb.append(String.valueOf(curr.val) + ",");
                que.offer(curr.left);
                que.offer(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] treeData = data.split(",");
        if (treeData[0] == "#") {
            return null;
        }

        Queue<TreeNode> que = new LinkedList<>();
        int n = treeData.length, ptr = 0;
        TreeNode root = new TreeNode(Integer.parseInt(treeData[ptr++]));
        que.offer(root);
        while (ptr < n && !que.isEmpty()) {
            TreeNode curr = que.poll();
            if (!treeData[ptr].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(treeData[ptr]));
                if (curr.left != null)
                    que.offer(curr.left);
            }
            ptr++;
            if (ptr < n && !treeData[ptr].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(treeData[ptr]));
                if (curr.right != null)
                    que.offer(curr.right);
            }
            ptr++;
        }
        return root;
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
