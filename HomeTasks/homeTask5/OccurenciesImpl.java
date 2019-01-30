
package homeTask5;

import java.io.*;
import java.util.Arrays;

public class OccurenciesImpl implements Occurencies {
    private String[] words;
    private String res;

     OccurenciesImpl(String[] words, String res) {
        this.words = words;
        this.res = res;
    }

    @Override
    public void getOccurencies(String[] sources, String[] words, String res) {
        for (String source : sources) {
            sourceReader(source);
        }
    }

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
        //System.out.println(buffer.toString());
        createSentences(buffer.toString());
    }

    private void createSentences(String buffer) {
        String[] sentences = buffer.trim().split("!\\.\\?");
        wordFinder(sentences);
    }

    private void wordFinder(String[] sentences) {
        StringBuffer saveSentence = new StringBuffer();

        for (String sentence : sentences) {
            //String[] splited = sentence.split(" ");
            for (String word : words) {
                if (sentence.contains(word)) {
                    saveSentence.append(sentence);
                }
            }
        }
            fileWriter(saveSentence);
    }

    private void fileWriter(StringBuffer saveSentence) {
        try (FileWriter fileWriter = new FileWriter(res)){
            fileWriter.write(saveSentence.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
