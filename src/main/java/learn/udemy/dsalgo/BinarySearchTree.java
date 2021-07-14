package learn.udemy.dsalgo;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinarySearchTree<T> insert(T value) {
        if (root == null) {
            root = new TreeNode<>(value);
        } else {
            root.insert(value);
        }
        return this;
    }

    public void printLevelOrder() {
        if (root == null) {
            return;
        }
        System.out.print("LevelOrder:");
        root.printLevelOrder();
        System.out.println();
    }

    public void printInOrder() {
        if (root == null) {
            return;
        }
        System.out.print("InOrder   :");
        root.printInOrder();
        System.out.println();
    }

    public void printPreOrder() {
        if (root == null) {
            return;
        }
        System.out.print("PreOrder  :");
        root.printPreOrder();
        System.out.println();
    }

    public void printPostOrder() {
        if (root == null) {
            return;
        }
        System.out.print("PostOrder :");
        root.printPostOrder();
        System.out.println();
    }

    private static class TreeNode<T extends Comparable<T>> {
        private final T data;
        private TreeNode<T> leftNode;
        private TreeNode<T> rightNode;

        private TreeNode(T data) {
            this.data = data;
        }

        public void insert(T value) {
            if (value.equals(data)) {
                return;
            }
            if (value.compareTo(data) < 0) {
                if (leftNode == null) {
                    leftNode = new TreeNode<>(value);
                } else {
                    leftNode.insert(value);
                }
            } else {
                if (rightNode == null) {
                    rightNode = new TreeNode<>(value);
                } else {
                    rightNode.insert(value);
                }
            }
        }

        public void printLevelOrder() {
            Queue<TreeNode<T>> nodes = new LinkedList<>();
            nodes.add(this);
            while (!nodes.isEmpty()) {
                TreeNode<T> node = nodes.remove();
                System.out.print(" " + node.data);
                if (node.leftNode != null) {
                    nodes.add(node.leftNode);
                }
                if (node.rightNode != null) {
                    nodes.add(node.rightNode);
                }
            }
        }

        public void printPreOrder() {
            System.out.print(" " + data);
            if (leftNode != null) {
                leftNode.printPreOrder();
            }
            if (rightNode != null) {
                rightNode.printPreOrder();
            }
        }

        public void printInOrder() {
            if (leftNode != null) {
                leftNode.printInOrder();
            }
            System.out.print(" " + data);
            if (rightNode != null) {
                rightNode.printInOrder();
            }
        }

        public void printPostOrder() {
            if (leftNode != null) {
                leftNode.printPostOrder();
            }
            if (rightNode != null) {
                rightNode.printPostOrder();
            }
            System.out.print(" " + data);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(25).insert(20).insert(15).insert(27).insert(30).insert(29).insert(26).insert(22).insert(32);
        bst.printPreOrder();
        bst.printInOrder();
        bst.printPostOrder();
        bst.printLevelOrder();
    }
}
