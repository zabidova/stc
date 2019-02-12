package homeTasks.homeTask9;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * @param words   Словарь для поиска вхождений
     * @param res     адрес файла для записи результатов поиска.
     */
    @Override
    public void getOccurencies(String[] sources, String[] words, String res) {
        Arrays.stream(sources).forEach(this::sourceReader);
    }

    /**
     * Читает данные с ресурса
     *
     * @param filePath путь до исходного ресурса.
     */
    private void sourceReader(String filePath) {
        Path path = Paths.get(filePath);
        try (Stream<String> lineStream = Files.lines(path)) {
            createSentences(lineStream.collect(Collectors.joining()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createSentences(String buffer) {
        String[] sentences = buffer
                .replaceAll("\\.", ".#")
                .replaceAll("!", "!#")
                .replaceAll("\\?", "?#")
                .split("#");
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
        List<String> dictionary = Arrays.asList(words);
        Stream.of(sentences)
                .filter(s ->
                        (!Collections.disjoint(
                                Arrays.asList(s.split("[^(а-яА-Яa-zA-Z)]")),
                                dictionary)
                        )
                )
                .forEach(saveSentence::append)
        ;
        System.out.println(saveSentence.toString());
        fileWriter(saveSentence);
    }

    /**
     * запись результатов поиска в файл.
     *
     * @param saveSentence путь до исходного файла
     */
    private void fileWriter(StringBuffer saveSentence) {
        try (FileWriter fileWriter = new FileWriter(res)) {
            fileWriter.write(saveSentence.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
