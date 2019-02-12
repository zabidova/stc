package homeTasks.homeTask9;

public class Main {
    public static void main(String[] args) {
        String[] sources = {"text0.txt"};
        String[] words = {"Казань", "Казани", "Казанского", "Казанью"};
        String res = "text4.txt";
        for (int i = 0; i < sources.length; i++) {
            new WorkingThread(sources, words, res).start();
        }
    }
}
