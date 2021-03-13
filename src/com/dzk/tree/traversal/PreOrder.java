package com.dzk.tree.traversal;


import com.dzk.Test;
import com.dzk.list.ListNode;
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
//        List<Integer> result = preOrderTraversalByIterator(root);
        List<Integer> result = preOrderTraversalByMorris(root);
        System.out.println(result);
    }

    //方法三  Mirrors方法
    /**
     * 巧妙的方法可以在线性时间内，只占用常数空间来实现前序遍历。这种方法由 J. H. Morris 在 1979 年的论文「Traversing Binary Trees Simply and Cheaply」中首次提出，因此被称为 Morris 遍历。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    private static List<Integer> preOrderTraversalByMorris(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.leftTree;
            if (p2 != null) {
                while (p2.rightTree != null && p2.rightTree != p1) {
                    p2 = p2.rightTree;
                }
                if (p2.rightTree == null) {
                    res.add(p1.val);
                    p2.rightTree = p1;
                    p1 = p1.leftTree;
                    continue;
                } else {
                    p2.rightTree = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.rightTree;
        }
        return res;

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
    List<Integer> preNode(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() && node != null){
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
