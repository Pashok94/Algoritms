import java.util.Arrays;

public class MyArray<E extends Object & Comparable<? super E>> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] arr;
    private int size;

    public MyArray(){
        this.arr = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArray(int size){
        this.arr = (E[]) new Object[size];
    }

    public int size(){
        return size;
    }

    public void add(E element){
        checkGrow();
        arr[size] = element;
        size++;
    }

    public void addAll(E... elements){
        for (E element: elements) {
            this.add(element);
        }
    }

    public E get(int index){
        return arr[index];
    }

    private void checkGrow(){
        if(size == arr.length){
            arr = Arrays.copyOf(arr, arr.length*2);
        }
    }

    public boolean remove(int index){
        if(index < 0 && index >= size){
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
        return true;
    }

    public int indexOf(E value){
        if(value == null)
            return -1;
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(value))
                return i;
        }
        return -1;
    }

    public long sortBubble(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0){
                    swap(j, j+1);
                }
            }
        }
        return (System.currentTimeMillis() - start);
    }

    public long  sortSelect(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(minIndex, i);
        }
        return (System.currentTimeMillis() - start);
    }

    public long sortInsert(){
        long start = System.currentTimeMillis();
        for (int i = 1; i < size; i++) {
            E temp = arr[i];
            int in = i;
            while (in > 0 && arr[in - 1].compareTo(temp) >= 0){
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        return (System.currentTimeMillis() - start);
    }
    private void swap(int index1, int index2){
        E temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
