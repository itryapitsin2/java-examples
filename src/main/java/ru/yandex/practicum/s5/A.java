package ru.yandex.practicum.s5;

import java.util.Scanner;

public class A {
    public static int treeSolution(Node head) {
        int maxNode = head.value;

        if (head.left != null) {
            int left = treeSolution(head.left);
            maxNode = Math.max(maxNode, Math.max(head.value, left));
        }


        if (head.right != null) {
            int right = treeSolution(head.right);
            maxNode = Math.max(maxNode, Math.max(head.value, right));
        }

        return maxNode;
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
    }
    // <template>

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            int nodeCount = scanner.nextInt();
            scanner.nextLine();

            Node root = readTree(scanner, nodeCount);
            int max = treeSolution(root);

            System.out.println(max);
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
