
package HomeTask4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generator {
    private int m_Probality;
    private String[] m_Words;
    private int m_size;

    public void getFiles(String path, int n, int size, String[] words, int probability){
        this.m_Probality = probability;
        this.m_Words = words;
        this.m_size = size;
        for (int i = 0; i < n; i++) {
            String text = this.generateText(m_size);
            String fileName = "text_" + i + ".txt";
            try(FileOutputStream fos = new FileOutputStream(path + fileName)) {
                byte[] buffer = text.getBytes();
                fos.write(buffer,0,buffer.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//генерация текста
    private String generateText(int m_size){
        StringBuilder text = new StringBuilder();
        //int paragraphCount = 1 + (int) Math.random()*10;
        for (int i = 0; i < m_size; i++) {
            text.append(this.generateParagraph());

        }
        return text.toString();
    }
//генерация абзаца
    private String generateParagraph() {
        StringBuilder paragraph = new StringBuilder();
        int sentenceCount = 1 + (int)(Math.random()*20);
        for (int i = 0; i < sentenceCount; i++) {
            paragraph.append(this.generateSentence());
        }
        paragraph.append("\r\n");
        return paragraph.toString();
    }
//генерация предложения
    private String generateSentence() {
        int totalWordsCount = 1 + (int) (Math.random()*15);
        int specWordsCount =  totalWordsCount/this.m_Probality;
        int generateWordsCount = totalWordsCount - specWordsCount;
        int rnd = (int) (Math.random()* m_Words.length);
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < specWordsCount; i++) {
            sentence.append(m_Words[rnd]);
            sentence.append(" ");
        }
        for (int i = 0; i < generateWordsCount; i++) {
            sentence.append(generateWord());
            if (i == generateWordsCount - 1) {
                sentence.append(getWordPunctuationEnd());
            }
        }
        sentence.append(" ");
        sentence.setCharAt(0,sentence.substring(0,1).toUpperCase().charAt(0));
        return sentence.toString();
    }
//генерация слова
    private String generateWord() {
        String[] charset = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int wordSize = 1 + (int)(Math.random()*15);
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < wordSize; ++i) {
            int randomIndex = (int)(Math.random()*25);
            word.append(charset[randomIndex]);
        }
        word.append(" ");
        return word.toString();
    }
//генерация случайного знака препинания
    private String getWordPunctuationEnd() {
        String[] charset = {"!", "?", "."};
        int randomIndex = (int)(Math.random()*2);
        return charset[randomIndex];
    }
}
