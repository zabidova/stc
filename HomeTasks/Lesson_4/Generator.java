
package homeTask4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Этот класс генерирует предложения и запсывает в каталог path
 *
 * @author Sevinch
 */
public class Generator {
    private int probality;
    private String[] words;

    public Generator(int probality, String[] words) {
        this.probality = probality;
        this.words = words;
    }

    /**
     * Создает файл в указанной директории
     * Вызывает метод generateText
     *
     * @param path каталог для сгенерированных файлов
     * @param n количество файлов для генерации
     * @param size количество абзацев в файле
     * @param words словарь
     * @param probability вероятность с которой добавляются слова в предложение из словаря
     */
    public void getFiles(String path, int n, int size, String[] words, int probability){
        for (int i = 0; i < n; i++) {
            String text = generateText(size);
            String fileName = "text_" + i + ".txt";
            try(FileOutputStream fos = new FileOutputStream(path + fileName)) {
                byte[] buffer = text.getBytes();
                fos.write(buffer,0,buffer.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IOException");
                e.printStackTrace();
            }
        }
    }

    /**
     * Генерация текста
     * вызывает метод generateParagraph()
     *
     * @param size количество обзацев в файле
     * @return возвращает произвольный текст
     */
    private String generateText(int size){
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < size; i++) {
            text.append(this.generateParagraph());

        }
        return text.toString();
    }

    /**
     * генерация абзаца
     *
     * @return произвольные абзацы
     */
    private String generateParagraph() {
        StringBuilder paragraph = new StringBuilder();
        int sentenceCount = 1 + (int)(Math.random()*20);
        for (int i = 0; i < sentenceCount; i++) {
            paragraph.append(this.generateSentence());
        }
        paragraph.append("\r\n");
        return paragraph.toString();
    }

    /**
     * генерация предложения
     * ВызЫвает метод generateWord()
     *
     * @return произвольные предложения
     */
    private String generateSentence() {
        int totalWordsCount = 1 + (int) (Math.random()*15);
        int specWordsCount =  totalWordsCount/this.probality;
        int generateWordsCount = totalWordsCount - specWordsCount;
        int rnd = (int) (Math.random()* words.length);
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < specWordsCount; i++) {
            sentence.append(words[rnd]);
            sentence.append(" ");
        }
        for (int i = 0; i < generateWordsCount; i++) {
            sentence.append(generateWord());
            if ( i == generateWordsCount - 1) {
                sentence.append(getWordPunctuationEnd());
            }
            sentence.append(" ");
        }
        sentence.setCharAt(0,sentence.substring(0,1).toUpperCase().charAt(0));
        return sentence.toString();
    }

    /**
     * генерация слова
     *
     * @return произвольные слова
     */
    private String generateWord() {
        String[] charset = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int wordSize = 1 + (int)(Math.random()*15);
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < wordSize; ++i) {
            int randomIndex = (int)(Math.random()*25);
            word.append(charset[randomIndex]);
        }
        return word.toString();
    }

    /**
     * генерация случайного знака препинания
     *
     * @return прозивольный знак
     */
    private String getWordPunctuationEnd() {
        String[] charset = {"!", "?", "."};
        int randomIndex = (int)(Math.random()*2);
        return charset[randomIndex];
    }
}
