package com.dzk.homework.tree;

import com.dzk.tree.TreeNode;

/**
 * 二叉树的最大距离。
 * 如果我们把二叉树看做图，父子节点之间的连线看成是双向的，我们姑且定义“距离”为两个节点之间边的个数。写一个程序求一棵二叉树中相距最远的两个节点之间的距离。
 * 解题思路就是分别计算左右子树的最大高度，然后进行左右子树高度的相加，得出最大距离。
 */
public class MaxDistance {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,new TreeNode(2,new TreeNode(4,null,null),new TreeNode(5,null,null)),
                new TreeNode(3,new TreeNode(6,null,null),new TreeNode(7,null,new TreeNode(8,null,null))));
        int left = maxDistance(root.left,0);
        int right = maxDistance(root.right,0);
        int distance = left + right + 1;
        System.out.println(distance);
    }


    private static int maxDistance(TreeNode head,int height){
        if (head == null) return height;
        height += 1;
        int left = maxDistance(head.left,height);
        int right = maxDistance(head.right,height);
        return Math.max(left,right);
    }
}
