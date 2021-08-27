package me.p3074098.test;

public class Array<T> {

    private Object[] array;
    private int count;

    public Array(int length) {
        this.array = new Object[length];
    }

    public void insert(T object) {
        if (count == array.length) {
            Object[] temp = new Object[count * 2];
            for (int i = 0; i < count; i++)
                temp[i] = array[i];
            array = temp;
        }

        array[count++] = object;
        System.out.println("Array length: " + array.length);
    }

    public void removeAt(int index) {
        if (index >= count || index < 0)
            throw new IndexOutOfBoundsException("Index must be greater than 0 and less than the array size.");

        for (int i = index; i < count-1; i++)
                array[i] = array[i+1];

        array[index] = null;
        count -= 1;
    }

    public int indexOf(T object) {
        for (int i = 0; i < count; i++)
            if (array[i].equals(object))
                return i;

        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(array[i].toString());
    }


}
