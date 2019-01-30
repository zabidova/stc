package homeTask5;

/**
 * Класс поиска вхождений слов в ресурс.
 */
public class WorkingThread extends Thread {
    private String[] source;
    private String res;
    private String[] words;
    private OccurenciesImpl oc;

     WorkingThread(String[] source,String[] words, String res) {
        this.source = source;
        this.res = res;
        this.words = words;
        this.oc = new OccurenciesImpl(words, res);
    }

    @Override
    public void run() {
        System.out.println("Поток " + this.getName() + " запущен!");
        oc.getOccurencies(source, words, res);
    }
}
