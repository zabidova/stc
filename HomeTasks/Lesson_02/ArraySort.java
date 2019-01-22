/**
 * Этот класс использует алгоритм пузырьковой сортировки.
 * @author Sevinch
 */
public class ArraySort {

    /**
     *Метод {@code sort()} сортирует массив по возрастанию.
     */
    public static void sort(Integer[] arr) {
        for (Integer i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Integer temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
