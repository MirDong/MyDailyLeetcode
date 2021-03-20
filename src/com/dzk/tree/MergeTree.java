package com.dzk.tree;

/**
 * 归并两棵树
 *
 * Input:
 *        Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 *
 * Output:
 *          3
 *         / \
 *        4   5
 *       / \   \
 *      5   4   7
 *
 *      递归搜索获取
 */
public class MergeTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1,new TreeNode(3,new TreeNode(5,null,null),null),new TreeNode(2,null,null));
        TreeNode t2 = new TreeNode(2,new TreeNode(1,null,new TreeNode(4,null,null)),
                new TreeNode(3,null,new TreeNode(7,null,null)));
        TreeNode treeNode = mergeBinaryTree(t1,t2);
        System.out.println(treeNode.val);
    }

    private static TreeNode mergeBinaryTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.leftTree = mergeBinaryTree(t1.leftTree,t2.leftTree);
        root.rightTree = mergeBinaryTree(t1.rightTree,t2.rightTree);
        return root;
    }

    private static TreeNode merge(TreeNode t1,TreeNode t2){
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode head = new TreeNode(t1.val + t2.val);
        head.leftTree = merge(t1.leftTree,t2.leftTree);
        head.rightTree = merge(t1.rightTree,t2.rightTree);
        return head;

    }
}
