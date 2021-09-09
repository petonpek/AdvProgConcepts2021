package me.p3074098.newlinkedlist;

public class LList {

    private Node head;

    public void addFront(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void addEnd(int value) {
        
    }

    private static class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
