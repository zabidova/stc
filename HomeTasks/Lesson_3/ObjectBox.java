package Lesson3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Хранит коллекцию obj
 */
public class ObjectBox {
    protected Collection obj;

    /**
     * Инициализирует коллекцию
     */
    public ObjectBox() {
        obj = new ArrayList();
    }

    /**
     * Добавляет обьект в коллекцию
     *
     * @param obj добавляемый элемент
     * @return возвращает true в случае успешного добавления
     */
    protected Boolean addObject(Object obj){
       return this.obj.add(obj);
    }

    /**
     * Удаляет объект из коллекции
     *
     * @param o удаляемый элемент
     * @return возвращает true при успешнном удалении
     */
    protected Boolean deleteObject(Object o) {
        if (o == null) return false;
        return obj.remove(o);
    }

    /**
     *
     * @return возвращет содержимое коллекции в виде строки
     */
    protected String dump() {
        return obj.toString();
    }

    public String toString() {
        return "ObjectBox{" +
                "obj=" + obj +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox objectBox = (ObjectBox) o;
        return Objects.equals(obj, objectBox.obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj);
    }
}
