package com.dzk.tree.traversal;

import com.dzk.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历
 */
public class InOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
//        List<Integer> result = inOrderTraversal(root);
//        List<Integer> result = inOrderByRecursive(root);
        List<Integer> result = inOrderTraversalByMorris(root);
        System.out.println(result);

    }

    //方法三   从最左侧开始顺着右节点打印。也就是在将cur切换到上层节点的时候。
    private static List<Integer> inOrderTraversalByMorris(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        TreeNode cur = root;
        TreeNode cur2 = null;
        //构建连接线
        while (cur != null){
            cur2 = cur.leftTree;
            if (cur2 != null){
                while (cur2.rightTree != null && cur2.rightTree != cur){
                    cur2 = cur2.rightTree;
                }
                if (cur2.rightTree == null){
                    cur2.rightTree = cur;
                    cur = cur.leftTree;
                    continue;
                }else {
                    cur2.rightTree = null;
                }
            }

            res.add(cur.val);
            cur = cur.rightTree;
        }
        return res;
    }

    //方法一  递归
    private static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        return inOrderByRecursive(root, res);
    }

    private static List<Integer> inOrderByRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return null;
        }
        inOrderByRecursive(root.leftTree, res);
        res.add(root.val);
        inOrderByRecursive(root.rightTree, res);
        return res;
    }

    //方法二  迭代
    private static List<Integer> inOrderByRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.leftTree;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.rightTree != null) {
                cur = node.rightTree;
            }
        }
        return res;
    }
}
