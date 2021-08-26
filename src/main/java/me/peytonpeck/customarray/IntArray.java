package me.peytonpeck.customarray;

public class IntArray {

    private int[] array;
    private int count;

    public IntArray(int length) {
        this.array = new int[length];
    }

    public void removeAt(int index) {
        if (index >= count || index < 0)
            throw new IndexOutOfBoundsException("Index must be greater than 0 and less than the array size.");

        for (int i = index; i < count-1; i++)
                array[i] = array[i+1];

        array[count-1] = 0;
        count -= 1;
    }

    public int indexOf(int object) {
        for (int i = 0; i < count; i++)
            if (array[i] == object)
                return i;

        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(array[i]);
    }

    public int max() {
        int max = Integer.MIN_VALUE;

        for (int i : array)
            if (i > max)
                max = i;

            return max;
    }

    public void reverse() {
        int[] temp = new int[count];

        for (int i = 0; i < count; i++)
            temp[i] = array[count-1-i];

        array = temp;
    }

    public void insert(int object) {
        insertAt(count, object);
    }

    public void insertAt(int index, int item) {
        int[] temp;

        if (count == array.length)
            temp = new int[count*2];
        else
            temp = new int[array.length];

        for (int i = 0; i < count; i++)
            if (i < index)
                temp[i] = array[i];
            else
                temp[i+1] = array[i];

            temp[index] = item;

            array = temp;
            count++;
    }
    
    
}
