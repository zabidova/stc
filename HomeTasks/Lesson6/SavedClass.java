package homeTask6;

public class SavedClass {
    private String name;
    private int id;

    public SavedClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public SavedClass() {

    }

    @Override
    public String toString() {
        return "SavedClass{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
