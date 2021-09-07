package me.p3074098.linkedlist;

public class NodeFun {

    public static void main(String[] args) {
        Node list = new Node(1);
        Node list2 = new Node(2);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        System.out.println("Printing nodes...");
        printNode(list);
        printNode(list2);

        list.next = list2;
        list2 = list.next.next;
        list2.next = null;

        System.out.println("Testing (1)...");
        printNode(list);
        printNode(list2);

        list.next.next.next = list;
        list = list.next.next;
        list.next.next.next.next = null;

        System.out.println("Printing again!");
        printNode(list);
        printNode(list2);
    }

    private static void printNode(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static class Node {

        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
