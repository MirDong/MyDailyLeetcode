package com.dzk.study.tree;


import com.dzk.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层次遍历
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1,new TreeNode(3,new TreeNode(5,null,null),null),new TreeNode(2,null,null));
        List<List<Integer>> order = levelOrder(t1);
        System.out.println(order);
    }

    private static List<List<Integer>> levelOrder(TreeNode head){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (head == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
