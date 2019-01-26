package homeTask7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyWorkerClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass starts work: " + name);
        if ("homeTask7.Myworker".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(""));
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}