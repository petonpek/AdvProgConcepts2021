package me.p3074098.linkedlist;


public class FunLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
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
            tail.next = node;
            tail = node;
            count++;
            return;
        }

        Node<T> next = head;
        for (int i = 0; i < index - 1; i++)
            next = next.next;

        Node<T> replaced = next.next;

        next.next = node;
        node.next = replaced;
    }

    public FunLinkedList() {

    }

    public void remove(int index) {

        if (index < 0 || index >= count)
            throw new IllegalArgumentException("You must enter an index that is within the bounds of the size of the list");

        if (index == 0) {
            head = head.next;
            count--;
            return;
        }

        Node<T> next = head;
        for (int i = 0; i < index-1; i++)
            next = next.next;

        Node<T> after = next.next.next;
        next.next = after;

        count--;
    }

    public void remove(T object) {
        Node<T> next = head;
        for (int i = 0; i < count; i++)
            if(next.data.equals(object))
                remove(i);
            else
                next = next.next;
    }

    public int getSize() {
        return count;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
