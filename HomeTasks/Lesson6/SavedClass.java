package homeTask6;

import java.io.Serializable;

public class SavedClass {
    private String name;
    private int id;

    public SavedClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "SavedClass{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
