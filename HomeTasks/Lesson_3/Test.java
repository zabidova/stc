
import java.util.Random;

/**
 * Содержит массив list
 */
public class Test {
    private Integer[] list = new Integer[10];

    /**
     * Создает объект класса и рандомно заполняет массив значениями
     * Создает объект класса MathBox и передает массив в качестве аргумента
     * Вызывает методы MathBox
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Test test = new Test();
        Random random = new Random();
        for (int i = 0; i < test.list.length; i++) {
            test.list[i] = random.nextInt();
        }
        MathBox mathBox = new MathBox(test.list);
        System.out.println(mathBox.summator());
        System.out.println(mathBox.deleteNum(7));
        System.out.println(mathBox.splitter(5.9));

    }
}
