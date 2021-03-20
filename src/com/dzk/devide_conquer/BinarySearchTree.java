package com.dzk.devide_conquer;

import com.dzk.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * (opens new window)
 * <p>
 * 给定一个数字 n，要求生成所有值为 1...n 的二叉搜索树。
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        generateTree(3);
    }

    private static List<TreeNode> generateTree(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }

        return generateSubTree(1, n);
    }

    private static List<TreeNode> generateSubTree(int m, int n) {
        List<TreeNode> list = new LinkedList<>();
        if (m > n) {
            list.add(null);
            return list;
        }
        for (int i = 1; i < n; i++) {
            TreeNode treeNode = new TreeNode(i);
            List<TreeNode> leftSubTree = generateSubTree(m, i - 1);
            List<TreeNode> rightSubTree = generateSubTree(i + 1, n);
            for (TreeNode left : leftSubTree) {
                for (TreeNode right : rightSubTree) {
                    treeNode.leftTree = left;
                    treeNode.rightTree = right;
                    list.add(treeNode);
                }
            }
        }


        return list;
    }


    private static List<TreeNode> makeTree(int m ,int n){
        List<TreeNode> res = new ArrayList<>();
         if (m > n){
             res.add(null);
             return res;
         }

        for (int i = 1; i < n; i++) {
            TreeNode rootNode = new TreeNode(i);
            List<TreeNode> leftSubTree = makeTree(0,i - 1);
            List<TreeNode> rightSubTree = makeTree(i + 1,n);
            for (TreeNode left:leftSubTree) {
                for (TreeNode right : rightSubTree) {
                    rootNode.leftTree = left;
                    rootNode.rightTree = right;
                    res.add(rootNode);
                }
            }
        }
        return res;
    }
}
