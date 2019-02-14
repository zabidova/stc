package homeTasks.homeTask7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Переопределенный ClassLoader. В случае запроса myWorker возвращает Class иначе искользует super.
 */
public class MyWorkerClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass starts work: " + name);
        if ("homeTasks.homeTask7.MyWorker".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("./MyWorker.class"));
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}