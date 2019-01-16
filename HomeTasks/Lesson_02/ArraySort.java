/**
 * Этот класс использует алгоритм ... сортировки.
 * @author Sevinch
 */
public class ArraySort {
    private static Integer[] arr = {100, 57, 98, 200, 1, 156, 900, 7}; // массив, который нужно отсортировать

    /**
     * Метод {@code main(String[])} создаёт объект класса и выполняет сортировку.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        sort();
    }

    /**
     *Метод {@code sort()} сортирует массив по возрастанию.
     */
    private static void sort() {
        for (Integer i = arr.length - 1; i > 0; i--) {
            for (Integer j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}