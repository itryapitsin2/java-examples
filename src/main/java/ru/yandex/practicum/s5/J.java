package ru.yandex.practicum.s5;

public class J {
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(null, null, key);
        }

        if (root.getValue() > key) {
            Node left = insert(root.getLeft(), key);
            root.setLeft(left);
        } else {
            Node right = insert(root.getRight(), key);
            root.setRight(right);
        }

        return root;
    }

    // <template>
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    // <template>

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Node node1 = new Node(null, null, 7);
        Node node2 = new Node(node1, null, 8);
        Node node3 = new Node(null, node2, 7);
        Node newHead = insert(node3, 6);
        assert newHead == node3;
        assert newHead.getLeft().getValue() == 6;
    }
}
