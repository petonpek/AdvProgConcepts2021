package me.p3074098.array;

import java.util.function.Predicate;

public class IntArray {
    
    private int[] array;
    private int count;
    
    public IntArray(int length) {
        this.array = new int[length];
    }
    
    public void removeAt(int index) {
        if (index >= count || index < 0)
            throw new IndexOutOfBoundsException("Index must be greater than 0 and less than the array size.");
        
        for (int i = index; i < count - 1; i++)
            array[i] = array[i + 1];

        count--;
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
        System.out.println();
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
            temp[i] = array[count - 1 - i];
        
        array = temp;
    }
    
    public void insert(int object) {
        insertAt(count, object);
    }
    
    public void insertAt(int index, int item) {
        
        if (index < 0 || index > count)
            throw new IllegalArgumentException("You must enter an index greater than 0 but less than or equal to the count!");
        
        int[] temp;
        
        if (count == array.length)
            temp = new int[count * 2];
        else
            temp = new int[array.length];
        
        for (int i = 0; i < count; i++)
            if (i < index)
                temp[i] = array[i];
            else
                temp[i + 1] = array[i];
        
        temp[index] = item;
        
        array = temp;
        count++;
    }
    
    public void clear() {
        for (int i = 0; i < count; i++)
            array[i] = 0;
        
        count = 0;
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean contains(int item) {
        for (int i : array)
            if (i == item)
                return true;
        
        return false;
    }
    
    public void removeIf(Predicate<Integer> predicate) {
        boolean bool;
        
        do {
            bool = false;
            for (int i = 0; i < count; i++) {
                if (predicate.test(array[i])) {
                    removeAt(i);
                    bool = true;
                    break;
                }
            }
        } while (bool);
    }
    
    public void insertAll(int... items) {
        for (int i : items)
            insert(i);
    }
    
    
}
