package com.dzk.tree.traversal;

import com.dzk.tree.TreeNode;

public class isValidBinarySearchTree {
    private static TreeNode prev;
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(2,new TreeNode(1,null,null),new TreeNode(3,null,null));
        TreeNode head = new TreeNode(5,new TreeNode(4,null,null),new TreeNode(6,new TreeNode(3,null,null),
                new TreeNode(7,null,null)));
        boolean isValid = isValidByCompare(head);
        /*TreeNode head2 = new TreeNode(2,null,null);
        System.out.println(isValidByInOrder(head2));*/
        System.out.println(isValid);
    }

    //解题思路一,中序遍历，比较当前节点与前继节点的大小
    private static boolean isValidByInOrder(TreeNode root){
        if (root == null) return true;
        if (!isValidByInOrder(root.left)) return false;
        if (prev != null && prev.val >= root.val) return false;
        prev = root;
        if (!isValidByInOrder(root.right)) return false;
        return true;
    }

    //解题思路二 左子树的最大值小于根节点的值，右子树的最小值大于根节点
    private static boolean isValidByCompare(TreeNode root){
        if (root == null) return true;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        max = findMaxMumNode(root.left,max);
        min = findMinmumNode(root.right,min);
        if (max >= root.val || min <= root.val){
            return false;
        }
        return true;
    }

    private static int findMinmumNode(TreeNode root, int min) {
        if (root == null) return min;
        findMinmumNode(root.left, min);
        min = Math.min(min,root.val);
        findMinmumNode(root.right,min);
        return min;
    }

    private static int findMaxMumNode(TreeNode root, int max) {
        if (root == null) return max;
        findMaxMumNode(root.left,max);
        if (max == -1){
            max = root.val;
        }else {
            max = Math.max(max,root.val);
        }
        findMaxMumNode(root.right,max);
        return max;
    }
}
