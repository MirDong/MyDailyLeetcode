package com.dzk.tree;

public class TreeNode {
    public int val;
    public TreeNode leftTree;
    public TreeNode rightTree;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode leftTree, TreeNode rightTree) {
        this.val = val;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }
}
