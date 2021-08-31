package me.p3074098.linkedlist;

<<<<<<< HEAD
import java.util.Iterator;
import java.util.LinkedList;

=======
>>>>>>> 6a57e063d1632c546075f6abec662a647c3d4f04
public class FunLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
<<<<<<< HEAD
    private int count = 0;

    public void insert(T object) {
        insert(count, object);
    }

    public void insert(int index, T object) {
        Node<T> node = new Node<>(object);

        if (count == 0) {
            head = node;
            tail = node;
            count++;
            return;
        }

        if (index == count) {
            tail.setNext(node);
            tail = node;
            count++;
            return;
        }

        Node<T> next = head;
        for (int i = 0; i < index-1; i++)
            next = next.getNext();

        Node<T> replaced = next.getNext();

        next.setNext(node);
        node.setNext(replaced);
=======

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
>>>>>>> 6a57e063d1632c546075f6abec662a647c3d4f04
    }

    public void remove(int index) {

<<<<<<< HEAD
        if (index < 0 || index >= count)
            throw new IllegalArgumentException("You must enter an index that is within the bounds of the size of the list");

        if (index == 0) {
            head = head.getNext();
            count--;
            return;
        }

        Node<T> next = head;
        for (int i = 0; i < index-1; i++)
            next = next.getNext();

        Node<T> after = next.getNext().getNext();
        next.setNext(after);

        count--;
    }

    public void remove(T object) {
        Node<T> next = head;
        for (int i = 0; i < count; i++)
            if(next.getData().equals(object))
                remove(i);
            else
                next = next.getNext();
    }

    public int getSize() {
        return count;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
=======
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
>>>>>>> 6a57e063d1632c546075f6abec662a647c3d4f04
    }
}
