package homeTask6;

public class Main {

    public static void main(String[] args) {
        String fileName = "D:\\my\\text_3.txt";
        String name = "Saved Class";
        int id = 1;
        SavedClass savedClass = new SavedClass(name, id);

        Serializer serializerImpl = new SerializerImpl();
        serializerImpl.serialize(savedClass, fileName);
        serializerImpl.deSerialize(fileName);
    }
}
