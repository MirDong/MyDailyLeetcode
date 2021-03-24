package com.dzk.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode allTree = reConstructTree(pre,in);
        System.out.println(allTree);
    }
private static Map<Integer,Integer> maps = new HashMap<>();
    private static TreeNode reConstructTree(int[] pre, int[] in) {
        for(int i = 0; i < in.length; i++){
           maps.put(in[i],i);
        }
        return reConstructTree(pre,0,pre.length - 1,0);
    }

    private static TreeNode reConstructTree(int[] pre, int startIndex, int endIndex, int leftIndex) {
        if (startIndex > endIndex){
            return null;
        }
        TreeNode rootNode = new TreeNode(pre[startIndex]);
        int rootIndex = maps.get(rootNode.val);
        int leftTreeSize = rootIndex - leftIndex;
        rootNode.left = reConstructTree(pre, startIndex + 1, startIndex + leftTreeSize, leftIndex);
        rootNode.right = reConstructTree(pre, startIndex +leftTreeSize + 1, endIndex, leftIndex + leftTreeSize + 1);
        return rootNode;
    }
}
