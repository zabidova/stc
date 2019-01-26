package homeTask6;

import java.io.*;
import java.lang.reflect.Field;

public class SerializerImpl implements Serializer {

    @Override
    public void serialize(Object object, String file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(openTag(object.getClass().getName()));
        stringBuilder.append("\n");
        Class c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            stringBuilder.append(openTag(field.getName() + " " + field.getType().getSimpleName()));
            try {
                stringBuilder.append(field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            stringBuilder.append(closeTag(field.getName()));
        }
        stringBuilder.append(closeTag(object.getClass().getName()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(stringBuilder.toString());
            System.out.println("Файл записан");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String openTag(String tag) {
        return "<" + tag + ">";
    }

    private String closeTag (String tag) {
        return "<" + tag + ">\n";
    }

    @Override
    public Object deSerialize(String file) {
        SavedClass savedClass = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            savedClass = (SavedClass) objectInputStream.readObject();
            System.out.println(savedClass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ClassNotFoundException");
        }
        return savedClass;
    }
}
