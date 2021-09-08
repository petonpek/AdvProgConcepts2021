package me.p3074098.linkedlist;

public class NodeFun {

    public static void main(String[] args) {
        FunNode list = new FunNode(1);
        list.next = new FunNode(2);
        list.next.next = new FunNode(3);
        list.next.next.next = new FunNode(4);

        System.out.println("Printing nodes...");
        printNode(list);

        FunNode list2 = list;
        list = list.next.next.next;
        list.next = list2.next;
        list2.next.next.next = list2;
        list2 = list2.next.next;
        list2.next.next = null;
        list.next.next = null;

        System.out.println("Testing (1)...");
        printNode(list);
        printNode(list2);

    }

    private static void printNode(FunNode node) {
        FunNode temp = node;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null)
                System.out.print(" --> ");
        }
        System.out.println();
    }

    private static class FunNode {

        public int data;
        public FunNode next;

        public FunNode(int data) {
            this.data = data;
        }
    }
}
