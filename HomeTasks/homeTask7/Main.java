package homeTask7;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Выполняет метод, введенный с консоли, в рантайме
 */
public class Main {

    private static final String OUT_FILE = "./MyWorker.java";

    /**
     * Считывает с консоли построчно код
     * Записывает в файл OUT_FILE
     * Подгружает в программу полученный файл и выполняет метод, введенный с консоли
     *
     * @param args аргументы командной строки
     * @throws IOException            обрабатываем ошибки, которые могут возникнуть при считывании с консоли и записи в файл
     * @throws ClassNotFoundException исключение, если класс не найден
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder builder = new StringBuilder();
        while (!(line = reader.readLine()).equals(" ")) {
            builder.append(line);
        }

        System.out.println("Файл создан");

        StringBuilder sb = new StringBuilder();
        String className = "MyWorker";

        sb.append("package homeTask7; public class " + className + " implements Worker { \n");
        sb.append("\n public " + className + "() { } \n");
        sb.append("  @Override\n  public void doWork() {\n" + builder + "}}");

        Files.write(Paths.get(OUT_FILE), sb.toString().getBytes());
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        int result = javaCompiler.run(null, null, null, OUT_FILE);
        System.out.println("Результат : " + result);

        ClassLoader classLoader = new MyWorkerClassLoader();
        Class myClass = classLoader.loadClass("homeTask7.MyWorker");

        Worker worker = null;
        try {
            worker = (Worker) myClass.getDeclaredConstructor().newInstance();

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        worker.doWork();
    }
}
