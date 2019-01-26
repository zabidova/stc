package homeTask4;

public class Test {

    /**
     * Метод создает экземпляр класса Generator и вызывает его метод getFiles
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        final String path = "D:\\my\\";
        int n = 2;
        String[] words = {"впервые","читатель", "может", "познакомиться", "с", "полной", "версией", "этого", "классического", "труда", "который", "ранее", "на", "русском", "языке", "печатался", "в", "сокращении"};
        int size = 4;
        int probability = 4;
        Generator generator = new Generator(probability, words);
        generator.getFiles(path, n, size, words, probability);
    }
}
