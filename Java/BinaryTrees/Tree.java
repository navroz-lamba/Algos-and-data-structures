package com.BinaryTrees;

import java.util.ArrayList;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
        // for readability during debugger
        @Override
        public String toString() {
            return "Node=" + value;
        }

    }
    private Node root;

    public void insert(int value) {

        var node = new Node(value);
        // where the Node is empty
        if (root == null) {
            root = new Node (value);
            return;
        }

        var current = root;
        while (true) {
            if (current.value > value) {
                // we go left
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            if (current.value < value) {
                // we go right
               if (current.rightChild == null) {
                   current.rightChild = node;
                   break;
               }
               current = current.rightChild;
            }
        }

    }

    public boolean find(int value) {
        // starting from the root node and traversing thru the tree
        var current = root;
        // we can't take an infinite while loop cuz it's possible value might not be in the tree
        while (current != null) {
            if (current.value > value)
                // we go left
                current = current.leftChild;
            else if (current.value < value)
                // we go right
                current = current.rightChild;
            else
            return true;
        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        // base condition
        if (root == null)
            return;
        // root (print)
        // left
        // right
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);

    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        // base condition
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        // base condition
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int findHeight() {
        return findHeight(root);
    }
    private int findHeight(Node root) {
        // base condition
        if (isLeaf(root))
            return 0;

        return 1 + Math.max(findHeight(root.leftChild),
                findHeight((root.rightChild)));
    }

    // finding min of a binary search tree
    public int findMinBinarySearch(Node root) {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    // Finding min of a non binary search tree
    private int findMinNonBinarySearch(Node root) {
        // base condition
        if (isLeaf(root))
            return root.value;

        var left = findMinNonBinarySearch(root.leftChild);
        var right = findMinNonBinarySearch(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        // base condition 1
        if (first == null && second == null)
            return true;
        // base condition 2
        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;

    }
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.value > max || root.value < min)
            return false;

        return
                isBinarySearchTree(root.leftChild, min, root.value - 1)
            && isBinarySearchTree(root.rightChild, root.value+1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;
        // base condition
        if (distance == 0) {
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.leftChild, distance-1, list);
        getNodesAtDistance(root.rightChild, distance-1, list);
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <=findHeight(); i++) {
            var list = getNodesAtDistance(i);
                for (var value : list)
                    System.out.println(value);

        }
    }

}
