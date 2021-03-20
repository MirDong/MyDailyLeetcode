package com.dzk.homework.tree;


import com.dzk.tree.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Executors;

/**
 * 前序遍历
 */
public class PreOrder {
    private List<Integer> res = new ArrayList<>();
    private List<Integer> preOrder(TreeNode root){
        if (root == null) return res;
        res.add(root.val);
        preOrder(root.leftTree);
        preOrder(root.rightTree);
        return res;
    }
}
