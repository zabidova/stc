
package homeTask6;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Выполняют сериализацию объекта Object в XML файл file и десериализацию объекта из этого файла.
 */
public class SerializerImpl implements Serializer {

    /**
     * Выполняют сериализацию объекта Object в файл file
     *
     * @param object Объект для сериализации
     * @param file Файл для сохранения объекта
     */
    @Override
    public void serialize(Object object, String file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(openTag(object.getClass().getName()));
        stringBuilder.append(System.getProperty("line.separator"));
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
           stringBuilder.append(System.getProperty("line.separator"));
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
        return "</" + tag + ">";
    }

    /**
     * Выполняет десериализацию из file в Object
     *
     * @param file file XML файл для извлечения объекта
     * @return Возвращает извлеченный объект
     */
    @Override
    public Object deSerialize(String file) {
        Class myClass;
        Object object = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            myClass = Class.forName(getName(line));
            object = myClass.getConstructor().newInstance();


            while ((line = reader.readLine()) != null) {
                String type = getName(line);
                String value = getValue(line);

                Field field;
                if (!"".equals(type) && value != null) {
                    try {
                        field = object.getClass().getDeclaredField(type);
                    } catch (Exception e) {
                        e.printStackTrace();

                        return object;
                    }

                    field.setAccessible(true);

                    switch (getType(line)) {
                        case "byte" :
                            field.setByte(object, Byte.parseByte(value));
                            break;
                        case "short" :
                            field.setShort(object, Short.parseShort(value));
                            break;
                        case "int" :
                            field.setInt(object, Integer.parseInt(value));
                            break;
                        case "long" :
                            field.setLong(object, Long.parseLong(value));
                            break;
                        case "float" :
                            field.setFloat(object, Float.valueOf(value));
                            break;
                        case "double" :
                            field.setDouble(object, Double.parseDouble(value));
                            break;
                        case "boolean" :
                            field.setBoolean(object, Boolean.parseBoolean(value));
                            break;
                        case "String" :
                            field.set(object, value);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("Ошибка InstantiationException");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("Ошибка InvocationTargetException");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("Ошибка NoSuchMethodException");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("Ошибка IllegalAccessExceptio");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка ClassNotFoundException");
            e.printStackTrace();
        }
        return object;
    }

    private String getType(String line) {
        String type = "";

        Pattern pattern = Pattern.compile("(?<=\\s).+?(?=>)");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            type = matcher.group();
        }
        System.out.println("type = " + type);
        return type;
    }

    private String getValue(String line) {
        String value = "";
        Pattern pattern = Pattern.compile("(?<=>).+?(?=<)");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            value = matcher.group();
        }
        System.out.println("value = " + value);
        return value;
    }

    private String getName(String line) {
        String name = "";
        Pattern pattern = Pattern.compile("(?<=<)[^/].+?(?=\\s|>)");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            name = matcher.group();
        }
        System.out.print("name = " + name );

        return name;
    }
}
