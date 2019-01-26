package homeTask5;

public class Main extends Thread {

    public static void main(String[] args) {
        String[] sources = {"D:\\my\\text_0.txt"};
        String[] words = {"Казань", "Казани", "Казанского"};
        String res = "D:\\my\\text_4.txt";
        WorkingThread[] threads = new WorkingThread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkingThread(sources, words, res);
            threads[i].start();
        }
    }
}
