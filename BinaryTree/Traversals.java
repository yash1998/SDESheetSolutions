package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversals {

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        preorder(root);
        return result;
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        postorder(root);
        return result;
    }

    public List<Integer> result;

    public void postorder(TreeNode root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        result.add(root.val);
    }

    // level by level traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> level;
        que.add(root);

        while(!que.isEmpty()) {
            level = new ArrayList<>();
            int n = que.size();
            for(int i=0; i<n; i++) {
                TreeNode curr = que.poll();
                level.add(curr.val);
                if (curr.left != null) que.add(curr.left);
                if (curr.right != null) que.add(curr.right);
            }
            result.add(level);
        }

        return result;
    }

    public List<Integer> preorderIterative(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            if (curr.right != null) st.push(curr.right);
            result.add(curr.val);
            if (curr.left != null) st.push(curr.left);
        }

        return result;
    }

    public List<Integer> inorderIterative(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) break;
                node = st.pop();
                result.add(node.val);
                node = node.right;
            }      
        }

        return result;
    }

    public List<Integer> postorderIterativeUsing2Stacks(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        result = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode curr = st1.pop();
            st2.push(curr.val);
            if (curr.left != null) st1.push(curr.left);
            if (curr.right != null) st1.push(curr.right);
        }
        while (!st2.isEmpty()) {
            result.add(st2.pop());
        }
        return result;
    }

    public List<Integer> postorderIterativeUsing1Stack(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while(node !=null || !st.isEmpty()) {
            if (node!=null) {
                st.push(node);
                node = node.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    result.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        result.add(temp.val);
                    }
                } else {
                    node = temp;
                }
            }
        } 

        return result;
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
