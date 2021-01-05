package com.dzk.tree;

/**
 * 平衡二叉树
 */
public class ALVTree {
    public static class Node {
        int data;
        Node leftChild;
        Node rightChild;
        int height;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root,30);
        root = insert(root,20);
        root = insert(root,40);
        root = insert(root,10);
        root = insert(root,25);

        root = insert(root,26);
        printTree(root);
    }

    public static void printTree(Node root) {
        if (root == null){
            return;
        }
        System.out.println(root.toString());
        if (root.leftChild != null){
            System.out.println("left:");
            printTree(root.leftChild);
        }
        if (root.rightChild != null){
            System.out.println("right:");
            printTree(root.rightChild);
        }
    }
    private static Node insert(Node root, int data) {
        if (root == null){
            root = new Node(data);
            return root;
        }
        //插入左子树
        if (data <= root.data){
            root.leftChild = insert(root.leftChild,data);
            if (getHeight(root.leftChild) - getHeight(root.rightChild) > 1) {
                //插入节点在失衡节点的左子树的左边
                if (data <= root.leftChild.data){
                    System.out.println("LL旋转");
                    root = LLRotate(root);
                }else {
                    System.out.println("LR旋转");
                    root = LRRotate(root);
                }
            }
        }else {//插入右子树
            root.rightChild = insert(root.rightChild,data);
            if (getHeight(root.leftChild) - getHeight(root.rightChild) > 1) {
                if (data < root.rightChild.data){//右左旋转
                    System.out.println("RL旋转");
                    root = RLRotate(root);
                }else {//右右旋转
                    System.out.println("RR旋转");
                    root = RRRotate(root);
                }
            }
        }
        //重新调整root节点的高度值
        root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
        return root;
    }
    // LR旋转
    private static Node LRRotate(Node p) {
        p.leftChild = RRRotate(p.leftChild);
        return LLRotate(p);
    }

    // RL旋转
    private static Node RLRotate(Node p) {
        p.rightChild = LLRotate(p.rightChild);
        return RRRotate(p);
    }

    /*
     * LL旋转
     * 左旋示意图(对结点20进行左旋)
     *      30                       20
     *     /  \                     /  \
     *    20  40                  10   30
     *   /  \      --LL旋转-       /   /  \
     *  10   25                  5   25   40
     *  /
     * 5
     *
     */
    private static Node LLRotate(Node p) {
        Node lsubtree = p.leftChild;
        p.leftChild = lsubtree.rightChild;
        lsubtree.rightChild = p;
        p.height = Math.max(getHeight(p.leftChild),getHeight(p.rightChild)) + 1;
        lsubtree.height = Math.max(getHeight(lsubtree.leftChild),p.height) + 1;
        return lsubtree;
    }

    /*
     * RR旋转
     * 右旋示意图(对结点30进行左旋)
     *      20                          30
     *     /  \                        /  \
     *    10  30                     20   40
     *       /  \      --RR旋转-     /  \   \
     *      25  40                 10  25  50
     *           \
     *           50
     *
     */

    public static Node RRRotate(Node p){
        Node rsubtree = p.rightChild;
        p.rightChild = rsubtree.leftChild;
        rsubtree.leftChild = p;
        // 重新设置失衡点20和新节点30的高度
        p.height = Math.max(getHeight(p.leftChild), getHeight(p.rightChild)) + 1;
        rsubtree.height = Math.max(getHeight(rsubtree.leftChild), getHeight(rsubtree.rightChild)) + 1;
        return rsubtree;
    }
    private static int getHeight(Node p) {
        return p == null ? -1 : p.height;
    }
}
