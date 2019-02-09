package homeTasks.homeTask10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int LOOP_COUNT = 100_000_000;

    public static void main(String[] args) {
        heapSpace();
    }

    /**
     * java.lang.OutOfMemoryError: Java heap space
     */
    private static void heapSpace() {
        List<String> list = new ArrayList<>();

        Random random = new Random();
        String str = "";
        for (int i = 0; i < LOOP_COUNT; i++) {
            str += "" + random.nextInt();
            list.add(str);
            if (i % 100 == 0) {
                list.remove(list.size() - 1);
            }
        }

        System.out.println(list.size());
    }
}
