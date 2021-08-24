package me.peytonpeck.customarray;


    public class OldArray<T> {

        private Object[] array;

        public OldArray() {
            this.array = new Object[0];
        }

        public void insert(T object) {
            Object[] temp = new Object[array.length + 1];

            for (int i = 0; i < array.length; i++)
                temp[i] = array[i];

            temp[temp.length - 1] = object;

            array = temp;
            System.out.println(array.length);
        }

        public void removeAt(int index) {
            Object[] temp = new Object[array.length - 1];

            boolean past = false;
            for (int i = 0; i < array.length; i++) {
                if (index == i) {
                    past = true;
                    continue;
                }

                temp[past ? i - 1 : i] = array[i];
            }

            array = temp;
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
                System.out.println(i);
            System.out.println("\n");
        }
    }
