package com.dzk.tree.traversal;

import com.dzk.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 后序遍历
 */
public class PostOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
//                List<Integer> result = postOrderTraversal(root);
        List<Integer> result = postOrderByRecursive(root);
        System.out.println(result);
    }

    // 方法二  迭代,使用双堆栈解决
    private static List<Integer> postOrderByRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            stack2.push(node);
            if (node.left != null){
                stack.push(node.left);
            }

            if (node.right != null){
                stack.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            TreeNode treeNode = stack2.pop();
            res.add(treeNode.val);
        }
        return res;
    }

    //方案一  递归解决
    private static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postOrder(root, res);
        return res;
    }

    private static void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }
}