
package homeTask5;

import java.io.*;

/**
 * Имплементация интерфейса поиска вхождений слов в текстовые ресурсы.
 */
public class OccurenciesImpl implements Occurencies {
    private String[] words;
    private String res;

     OccurenciesImpl(String[] words, String res) {
        this.words = words;
        this.res = res;
    }

    /**
     * Главный метод поиска вхождений слов из массива
     *
     * @param sources исходные ресурсы
     * @param words Словарь для поиска вхождений
     * @param res адрес файла для записи результатов поиска.
     */
    @Override
    public void getOccurencies(String[] sources, String[] words, String res) {
        for (String source : sources) {
            sourceReader(source);
        }
    }

    /**
     *
     * @param filePath путь до исходного ресурса.
     */
    private void sourceReader(String filePath) {
        StringBuffer buffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        createSentences(buffer.toString());
    }

    /**
     *
     *
     * @param buffer
     */
    private void createSentences(String buffer) {
        String[] sentences = buffer.trim().split("[!.?]");
        wordFinder(sentences);
    }

    /**
     * Проверка предложения на вхождение в него слов из словаря.
     * в случае положительного результата добавляется в очередь на запись в файл.
     *
     * @param sentences исходные предложения
     */
    private void wordFinder(String[] sentences) {
        StringBuffer saveSentence = new StringBuffer();

        for (String sentence : sentences) {
            for (String word : words) {
                if (sentence.contains(word)) {
                    saveSentence.append(sentence);
                }
            }
        }
            fileWriter(saveSentence);
    }

    /**
     *  запись результатов поиска в файл.
     *
     * @param saveSentence путь до исходного файла
     */
    private void fileWriter(StringBuffer saveSentence) {
        try (FileWriter fileWriter = new FileWriter(res)){
            fileWriter.write(saveSentence.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
