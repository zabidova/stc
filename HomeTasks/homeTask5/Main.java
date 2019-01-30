package homeTask5;

public class Main extends Thread {

    public static void main(String[] args) {
        String[] sources = {"D:\\my\\text10.txt"};
        String[] words = {"Казань", "Казани", "Казанского", "Казанью"};
        String res = "C:\\Users\\Syava\\IdeaProjects\\JC14\\text4.txt";
        for (int i = 0; i < 10; i++) {
            new WorkingThread(sources, words, res).start();
        }
    }
}
