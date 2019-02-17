package homeTasks.homeTask14;

import java.io.IOException;
import java.io.OutputStream;

public interface Occurencies {
    /**
     * Главный метод поиска вхождений слов из массива
     *
     * @param sources исходные ресурсы
     * @param words Словарь для поиска вхождений
     * @param res поток вывода для записи результатов поиска.
     * @throws IOException в случае ошибки ввода-вывода
     */
    void getOccurencies(String[] sources, String[] words, OutputStream res) throws IOException;
}
