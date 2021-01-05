package com.dzk.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 哈夫曼树：该树的带权路径长度最小
 */
public class HuffManTree {
    public static class Node<E>{
        E data;
        int weight;
        Node leftChild;
        Node rightChild;

        public Node(E data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node[" + weight + ",data=" + data + "]";
        }
    }
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("a",10));
        nodes.add(new Node("b",15));
        nodes.add(new Node("c",12));
        nodes.add(new Node("d",3));
        nodes.add(new Node("e",4));
        nodes.add(new Node("f",13));
        nodes.add(new Node("g",1));
        Node root = createTree(nodes);
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

    public static Node createTree(List<Node> nodes) {
        if (nodes == null){
            return null;
        }
        while (nodes.size() > 1){
            sort(nodes);
            Node leftChild = nodes.get(0);
            Node rightChild = nodes.get(1);
            Node parent = new Node(null,leftChild.weight + rightChild.weight);
            parent.leftChild = leftChild;
            parent.rightChild = rightChild;
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private static void sort(List<Node> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size() - 1 - i; j++) {
                if (nodes.get(j + 1).weight < nodes.get(j).weight){
                    Node temp = nodes.get(j + 1);
                    nodes.set(j+ 1,nodes.get(j));
                    nodes.set(j,temp);
                }
            }
        }
    }
}
