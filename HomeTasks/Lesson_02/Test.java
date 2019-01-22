import java.util.Arrays;
import java.util.Random;

public class Test {
    private static Integer[] arr = new Integer[10]; // массив, который нужно отсортировать

    /**
     * Метод {@code main(String[])} наполняет массив arr рандомно значениями и вызывает метод сортировки класса ArraySort.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        ArraySort arraySort = new ArraySort();
        System.out.println(Arrays.asList(arraySort.sort(arr)));
    }

}
