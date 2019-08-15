import java.util.Random;

public class MyArrayTest {
    public static void main(String[] args) {
//        MyArray<Integer> myArray = new MyArray<>();
//        System.out.println(myArray.size());
//        myArray.add(1);
//        System.out.println(myArray.size());
//        myArray.addAll(1,3,52,123, 11, 2, 4);
//        System.out.println(myArray.size());
//        myArray.remove(1);
//        System.out.println(myArray.size());
//        System.out.println("_____________");
//        for (int i = 0; i < myArray.size(); i++) {
//            System.out.print(myArray.get(i) + "; ");
//        }
//        System.out.println();
//        System.out.println("_____________");
//        myArray.sortBubble();
//        myArray.sortSelect();
//        myArray.sortInsert();
//        for (int i = 0; i < myArray.size(); i++) {
//            System.out.print(myArray.get(i) + "; ");
//        }

        Integer[] array = new Integer[100000]; //сделал на 100к, т.к на 1кк слишком долго сортирует, но и тут уже разница видна
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 1000000);
        }

        MyArray<Integer> myArraySortBubble = new MyArray<>();
        MyArray<Integer> myArraySortSelect = new MyArray<>();
        MyArray<Integer> myArraySortInsert = new MyArray<>();

        myArraySortBubble.addAll(array);
        myArraySortSelect.addAll(array);
        myArraySortInsert.addAll(array);

        long resulSortBubble = myArraySortBubble.sortBubble();
        System.out.println("SortBubble: " + resulSortBubble);

        long resulSortSelect = myArraySortSelect.sortSelect();
        System.out.println("SortSelect: " + resulSortSelect);

        long resultSortInsert = myArraySortInsert.sortInsert();
        System.out.println("SortInsert: " + resultSortInsert);
    }
}
