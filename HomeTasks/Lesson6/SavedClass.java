package homeTask6;

import java.io.Serializable;

public class SavedClass implements Serializable {
    private String name;
    private int id;

    public SavedClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
