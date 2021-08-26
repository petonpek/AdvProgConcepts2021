package me.peytonpeck.customarray;

import java.util.LinkedList;
import java.util.List;

public class ArrayRunner {

    public static void main(String[] args) {
        IntArray array = new IntArray(2);

        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.insert(50);

        array.print();
        System.out.println();

        array.insertAt(1, 15);

        array.print();
        System.out.println();

        array.removeAt(1);
        array.print();

        System.out.println("max: " + array.max());

        array.reverse();
        array.print();
    }
}
