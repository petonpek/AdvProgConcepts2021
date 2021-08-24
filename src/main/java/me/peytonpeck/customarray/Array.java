package me.peytonpeck.customarray;

public class Array<T> {

    private Object[] array;
    private int count;

    public Array(int length) {
        this.array = new Object[length];
    }

    public void insert(T object) {
        Object[] temp;

        if (count == array.length)
            temp = new Object[(int) (array.length*1.5)];
        else
            temp = array;

        for (int i = 0; i < count; i++)
            temp[i] = array[i];

        temp[count] = object;

        System.out.println("array length:" + temp.length);
        count += 1;
        array = temp;
    }

    public void removeAt(int index) {
        if (index >= count || index < 0)
            throw new IndexOutOfBoundsException("Index must be greater than 0 and less than the array size.");

        for (int i = 0; i < count; i++)
            if (i == count-1)
                array[i] = null;
            else if (i >= index)
                array[i] = array[i+1];

        count -= 1;
    }

    public int indexOf(T object) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(object))
                return i;
        }

        return -1;
    }

    public void print() {
        for (Object i : array)
            if (i != null)
            System.out.println(i);
    }
}
