package homeTasks.homeTask14;

import java.io.*;

class ReaderAndWriter {
    /**
     * Читает данные с ресурса
     *
     * @param filePath путь до исходного ресурса.
     */
    String sourceReader(String filePath) throws IOException {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        }
        return buffer.toString();
    }

    /**
     * запись результатов поиска в файл.
     *
     * @param saveSentence путь до исходного файла
     */
    void fileWriter(StringBuilder saveSentence, OutputStream res) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(res))) {
            writer.write(saveSentence.toString());
        }
    }
}
