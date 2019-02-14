package homeTasks.homeTask7;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
     * @throws IOException обрабатываем ошибки, которые могут возникнуть при считывании с консоли и записи в файл
     * @throws ClassNotFoundException исключение, если класс не найден
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StringBuilder builder = new StringBuilder();

        System.out.println("Введите код метода");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"".equals(line)) {
            builder.append(line).append(" ");
            line = scanner.nextLine();
        }

        String className = "MyWorker";

        String sb = "package homeTasks.homeTask7; public class " + className + " implements Worker { \n" +
                "\n public " + className + "() { } \n" +
                "  @Override\n  public void doWork() {\n" + builder + "}}";

        try {
            //String fileName = System.getProperty("user.dir") + "/src/main/ru/inno/homeTask7/" + className + ".java";
            Files.write(Paths.get(OUT_FILE), sb.getBytes());
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            javaCompiler.run(null, null, null, OUT_FILE);

            System.out.println("Файл создан");

            MyWorkerClassLoader classLoader = new MyWorkerClassLoader();
            Class myClass = classLoader.findClass("homeTasks.homeTask7.MyWorker");

            Worker worker = (Worker) myClass.getDeclaredConstructor().newInstance();
            worker.doWork();

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}