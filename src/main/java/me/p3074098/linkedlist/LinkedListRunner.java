package me.p3074098.linkedlist;

public class LinkedListRunner {

    public static void main(String[] args) {
        FunLinkedList<Integer> list = new FunLinkedList<>();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(1,15);
        list.remove(Integer.valueOf(20));

        Node<Integer> node = list.getHead();
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}
