package com.company;

import java.util.ArrayDeque;

public class BinarySearchTree {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addElement(7);
        binarySearchTree.addElement(10);
        binarySearchTree.addElement(6);
        binarySearchTree.addElement(4);
        binarySearchTree.addElement(22);
        binarySearchTree.printTreeBFS();
    }

    private class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    Node root;

    private void printTreeBFS() {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder(root.value);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            sb.append(currentNode.value).append(" ");
            if (currentNode.leftChild != null) {
                queue.offer(currentNode.leftChild);
            }
            if (currentNode.rightChild != null) {
                queue.offer(currentNode.rightChild);
            }
        }
        System.out.println(sb.toString());

    }

    void addElement(int element) {
        Node newElement = new Node(element);
        if (root == null) {
            root = newElement;
        } else {
            Node currentNode = root;
            while (true) {
                if (element < currentNode.value) {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = newElement;
                        break;
                    } else {
                        currentNode = currentNode.leftChild;
                    }
                } else {
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = newElement;
                        break;
                    } else {
                        currentNode = currentNode.rightChild;
                    }
                }
            }
        }

    }


}
