package com.dzk.homework.tree;

import com.dzk.tree.TreeNode;

/**
 * 检查子树。有2个非常大的二叉树T1和T2，判断T2是不是T1的子树
 */
public class CheckSubTree {
    /**
     * 思路，从根节点开始检测,
     * 1.t1与t2是否是一颗二叉树，如果是，则分别从t1,t2左右子树依次判断,否则，保持t2不变，从t1左右子树分别查找与t2节点相同的节点。
     * @param t1
     * @param t2
     * @return
     */
    private boolean checkSubTree(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null && t2 != null) return false;
        if (t1 != null && t2 == null) return true;
        if (t1.val == t2.val){
            return checkSubTree(t1.left,t2.left) && checkSubTree(t1.right,t2.right);
        }
        return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
    }
}
