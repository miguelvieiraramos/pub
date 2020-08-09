import java.util.List;

public interface SerializerInterface<T> {
    void write(List<T> list, String fileName);

    List<T> read(String fileName, Class Client);
}
