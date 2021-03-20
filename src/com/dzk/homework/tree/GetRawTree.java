package com.dzk.homework.tree;

import com.dzk.list.ListNode;
import com.dzk.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * 已知前序遍历为{1,2,4,7,3,5,6,8}，中序遍历为{4,7,2,1,5,3,8,6}，它的二叉树是怎么样的？
 * 3,9,20,15,7  preOrder
 * 9,3,15,20,7  inOrder
 */
public class GetRawTree {
    static Map<Integer,Integer> maps = new HashMap<>();
    private static TreeNode getRawTree(int[] pre,int[] in){
        for (int i = 0; i < in.length; i++) {
            maps.put(in[i],i );
        }

        return generateTree(pre,0,in.length - 1,0);
    }

    private static TreeNode generateTree(int[] pre, int startIndex, int endIndex, int left) {
        if (startIndex > endIndex) return null;
        int value = pre[startIndex];
        TreeNode root = new TreeNode(value);
        int rootIndex = maps.get(value);
        int leftTreeSize = rootIndex - left;
        root.leftTree = generateTree(pre,startIndex + 1,startIndex + leftTreeSize,left);
        root.rightTree = generateTree(pre, startIndex + leftTreeSize + 1, endIndex, left + leftTreeSize + 1);
        return root;
    }
}
