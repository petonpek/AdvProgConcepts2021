package me.p3074098.linkedlist;

public class FunLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public FunLinkedList() {

    }

    public void add(T data) {
        if (head == null)
            head = new Node<>(data);

        Node<T> node = new Node<>(data);
        Node<T> next = head;

        while (next.getNext() != null) {
            next = next.getNext();
        }
    }

    public void remove(int index) {

    }

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }
}
