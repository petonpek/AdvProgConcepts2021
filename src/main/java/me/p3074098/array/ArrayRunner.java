package me.p3074098.array;

public class ArrayRunner {

    public static void main(String[] args) {
        IntArray array = new IntArray(2);

        array.insert(10);
        array.insert(20);
        array.insert(30);

        array.insertAll(40, 60, 70, 80, 90, 100);

        array.insertAt(4, 50);

        array.print();

        System.out.println("Reverse!");

        array.reverse();
        array.print();

        System.out.println("Reverse again!");

        array.reverse();
        array.print();

        System.out.println("Array size?: " + array.size());
        System.out.println("Max: " + array.max());
        System.out.println("Contains 50? " + array.contains(50));
        System.out.println("Contains 55? " + array.contains(55));
        System.out.println("Where is the first instance of 40? " + array.indexOf(40));

        System.out.println("Remove all values above 80!");
        array.removeIf(number -> number > 80);

        array.print();

        System.out.println("Remove the value at the second index!");
        array.removeAt(1);

        array.print();

        System.out.println("Clear it!");
        array.clear();

        System.out.println("Is the array empty? " + array.isEmpty());
    }
}
