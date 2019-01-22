package Lesson3;

import java.util.Random;

public class Test {
    private Integer[] list = new Integer[10];

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
