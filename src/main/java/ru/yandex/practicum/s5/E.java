package ru.yandex.practicum.s5;

import java.util.Scanner;


public class E {
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

    public static boolean isBinaryTree(Node head, int min, int max) {
        if (head == null) {
            return true;
        }

        if (head.value <= min || head.value > max) {
            return false;
        }

        return isBinaryTree(head.left, min, head.value) && isBinaryTree(head.right, head.value, max);
    }

    public static boolean treeSolution(Node head) {
        return isBinaryTree(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int nodeCount = scanner.nextInt();
            scanner.nextLine();

            Node root = readTree(scanner, nodeCount);
            boolean isBinary = treeSolution(root);

            System.out.println(isBinary ? "True" : "False");
        }
    }

    private static Node readTree(Scanner scanner, int nodeCount) {
        Node[] nodes = new Node[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            nodes[i] = new Node(0);
        }

        for (int i = 0; i < nodeCount; i++) {
            String[] params = scanner.nextLine().split(" ");
            Node node = nodes[i];
            node.value = Integer.parseInt(params[1]);
            int leftId = params[2].equals("None") ? -1 :Integer.parseInt(params[2]);
            int rightId = params[3].equals("None") ? -1 : Integer.parseInt(params[3]);
            node.left = leftId != -1 ? nodes[leftId] : null;
            node.right = rightId != -1 ? nodes[rightId] : null;
        }

        return nodes[0];
    }
}

