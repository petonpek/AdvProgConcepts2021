package me.peytonpeck.customarray;

public class ArrayRunner {

    public static void main(String[] args) {
        int testLength = 300000;

        Array<Integer> array = new Array<>(3);

        long start = System.nanoTime();
        for (int i = 0; i < testLength; i++)
            array.insert(i);
        long end = System.nanoTime();

        OldArray<Integer> oldArray = new OldArray<>();

        long start2 = System.nanoTime();
        for (int i = 0; i < testLength; i++)
            oldArray.insert(i);
        long end2 = System.nanoTime();

        System.out.println((double)(end-start)/(double)1000000000 + "seconds (new)");
        System.out.println((double)(end2-start2)/(double)1000000000 + "seconds (old)");
    }
}
