import java.util.Random;

public class ArraySort {
    Integer[] arr = new Integer{100, 57, 98, 200, 1, 156, 900, 7};

    public static void main(String[] args) {
        ArraySort arraySort = new ArraySort();
        /*

         */
        arraySort.sort();
    }

    public void sort() {
        for (Integer i = arr.length - 1; i > 0; i--) {
            for (Integer j = 0; j < i; j++) {
                /** Функция сравнения элементов массива попарно,если они имеют неправильный порядок,
                то меняем местами*/
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (Integer i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
import java.util.Random;

public class ArraySort {
    Integer[] arr = new Integer[15];//{100, 57, 98, 200, 1, 156, 900, 7};

    public static void main(String[] args) {
        ArraySort arraySort = new ArraySort();
        /*

         */
        Random rnd = new Random();
        for (Integer i = 0; i < arraySort.arr.length; i++) {
            arraySort.arr[i] = rnd.nextInt();
            System.out.print(arraySort.arr[i] + " ");
        }
        arraySort.sort();
    }

    public void sort() {
        for (Integer i = arr.length - 1; i > 0; i--) {
            for (Integer j = 0; j < i; j++) {
                /** Функция сравнения элементов массива попарно,если они имеют неправильный порядок,
                то меняем местами*/
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (Integer i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
