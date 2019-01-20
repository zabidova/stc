package HomeTask4;

public class Test {
    private static String path = "D:\\my\\";
    private static int n = 2;
    private static String[] words = {"впервые","читатель", "может", "познакомиться", "с", "полной", "версией", "этого", "классического", "труда", "который", "ранее", "на", "русском", "языке", "печатался", "в", "сокращении"};
    private static int size = 4;
    private static int probability = 4;

    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.getFiles(path, n, size, words, probability);
    }
}
