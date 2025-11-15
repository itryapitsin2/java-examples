package ru.yandex.practicum.s5;

public class F {
    public static int treeSolution(Node head) {
        int leftDeep = 0;
        int rightDeep = 0;
        int deep = 1;
        if (head.left != null) {
            leftDeep = treeSolution(head.left);
        }

        if (head.right != null) {
            rightDeep = treeSolution(head.right);
        }

        deep += Math.max(leftDeep, rightDeep);
        return deep;
    }

    // <template>
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    // <template>

    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        int result = treeSolution(node5);

        assert result == 3;
    }

    public static void main(String[] args) {
        test();
    }
}
