package Lesson3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class ObjectBox {
    protected Collection obj;

    public ObjectBox() {
        obj = new ArrayList();
    }

    protected Boolean addObject(Object obj){
       return this.obj.add(obj);
    }

    protected Boolean deleteObject(Object o) {
        if (o == null) return false;
        return obj.remove(o);
    }

    protected String dump() {
        return obj.toString();
    }

    @Override
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
