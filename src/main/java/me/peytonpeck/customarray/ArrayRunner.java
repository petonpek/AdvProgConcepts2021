package me.peytonpeck.customarray;

public class ArrayRunner {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();

        array.insert(10);
        array.insert(20);
        array.insert(30);

        array.print();

        array.removeAt(1);

        array.print();

        System.out.println(array.indexOf(10));
    }
}
