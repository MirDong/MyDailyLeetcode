package com.dzk.tree.traversal;


import com.dzk.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jackie
 * 前序遍历
 *              1
 *          2       3
 *       4    5  6     7
 */
public class PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4,null,null),new TreeNode(5,null,null)),
                new TreeNode(3,new TreeNode(6,null,null),new TreeNode(7,null,null)));
//        List<Integer> result = preOrderTraversal(root);
        List<Integer> result = preOrderTraversalByIterator(root);
        System.out.println(result);
    }

    //方法一  递归
    private static List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preOrderByRecursive(root,res);
        return res;
    }

    private static List<Integer> preOrderByRecursive(TreeNode root, List<Integer> res) {
        if (root == null){
            return null;
        }
        res.add(root.val);
        preOrderByRecursive(root.leftTree,res);
        preOrderByRecursive(root.rightTree,res);
        return res;
    }


    //方法二  迭代
    private static List<Integer> preOrderTraversalByIterator(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                res.add(node.val);
                stack.push(node);
                node = node.leftTree;
            }
            node = stack.pop();
            node = node.rightTree;
        }
        return res;
    }

}
