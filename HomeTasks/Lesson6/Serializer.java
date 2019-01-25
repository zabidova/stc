package homeTask6;

public interface Serializer {
    void serialize (Object object, String file);

    Object deSerialize(String file);
}
