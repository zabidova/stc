package homeTasks.homeTask14;

import java.io.*;

public class OccurenciesImpl implements Occurencies{
    private final ReaderAndWriter readerAndWriter;

    public OccurenciesImpl(ReaderAndWriter readerAndWriter) {
        this.readerAndWriter = readerAndWriter;
    }

    @Override
    public void getOccurencies(String[] sources, String[] words, OutputStream res) throws IOException {
        for (String source : sources) {
            String[] sentences = createSentences(readerAndWriter.sourceReader(source));
            StringBuilder saveSentence = wordFinder(sentences, words);
            readerAndWriter.fileWriter(saveSentence, res);
        }
    }

    private String[] createSentences(String buffer) {
        return buffer.trim()
                .replaceAll("\\.",".#")
                .replaceAll("!","!#")
                .replaceAll("\\?","?#")
                .split("#");
    }

    /**
     * Проверка предложения на вхождение в него слов из словаря.
     * в случае положительного результата добавляется в очередь на запись в файл.
     *
     * @param sentences исходные предложения
     */
    private StringBuilder wordFinder(String[] sentences, String[] words) {
        StringBuilder saveSentence = new StringBuilder();

        for (String sentence : sentences) {
            for (String word : words) {
                if (sentence.contains(word)) {
                    saveSentence.append(sentence);
                    saveSentence.append(System.lineSeparator());
                }
            }
        }
        return saveSentence;
    }
}
