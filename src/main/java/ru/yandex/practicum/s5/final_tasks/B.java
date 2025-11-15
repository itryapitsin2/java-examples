package ru.yandex.practicum.s5.final_tasks;

// <template>
class Node {
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

/**
 * Объяснение решения сделано в файле README_A.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/24810/run-report/116831164/
 */
public class B {

    /**
     * Контайнер
     */
    private static class NodeWithParent {

        private Node parent;
        private Node node;

        NodeWithParent(Node parent, Node node) {
            this.parent = parent;
            this.node = node;
        }

        public Node getParent() {
            return parent;
        }

        public Node getNode() {
            return node;
        }
    }

    public static NodeWithParent findMin(Node head, Node parent) {
        NodeWithParent result = new NodeWithParent(parent, head);

        if (head.getLeft() != null) {
            return findMin(head.getLeft(), head);
        }

        return result;
    }

    public static Node remove(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.getValue() == key) {
            if (root.getRight() != null && root.getLeft() != null) {
                return changeNode(root).getNode();
            } else if (root.getLeft() != null) {
                return root.getLeft();
            } else {
                return root.getRight();
            }
        } else if (root.getValue() > key) {
            if (root.getLeft() != null) {
                root.setLeft(remove(root.getLeft(), key));
            }
        } else {
            if (root.getRight() != null) {
                root.setRight(remove(root.getRight(), key));
            }
        }

        return root;
    }

    private static NodeWithParent changeNode(Node root) {
        var minNode = findMin(root.getRight(), root);

        if (minNode.getParent().getLeft() == minNode.getNode()) {
            minNode.getParent().setLeft(minNode.getNode().getLeft());
        } else {
            minNode.getParent().setRight(minNode.getNode().getRight());
        }

        minNode.getNode().setLeft(root.getLeft());
        minNode.getNode().setRight(root.getRight());

        return minNode;
    }

    public static void main(String[] arg) {
        test();
    }

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        var value = newHead.getValue();
        var right = newHead.getRight();
        var rightValue = newHead.getRight().getValue();

        assert value == 5;
        assert right == node5;
        assert rightValue == 8;
    }
}
