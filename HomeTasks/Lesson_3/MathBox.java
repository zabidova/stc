package Lesson3;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Хранит отсортированные неповторящиеся элементы, расширяющие Number.
 *
 * @param <T> параметр должен расширять Number
 */
public class MathBox<T extends Number> extends ObjectBox{
    private TreeSet<T> arr;

    /**
     * Инициализирует коллекцию TreeSet
     *
     * @param arr
     */
    public MathBox(T[] arr ) {
        this.arr = new TreeSet(Arrays.asList(arr));
    }

    /**
     * суммирует все элементы коллекции
     *
     * @return в BigDecimal
     */
    public BigDecimal summator() {
        BigDecimal sum = BigDecimal.ZERO;
        for (T number : arr) {
            sum = sum.add(new BigDecimal(number.toString()));
        }
        return sum;
    }

    /**
     * делит все элементы коллекции на num
     *
     * @param num элемент на который делятся все элементы коллекции
     * @return новый элемент TreeSet с элементами поделенными на num
     */
    public Set<Double> splitter(Double num) {
        if (num == null) return null;
        TreeSet<Double> result = new TreeSet<>();
        arr.stream().forEach(o -> {
            result.add((o.doubleValue()) / num);
    });
        return result;
    }

    /**
     *  Удаляет элемент из коллекции
     *
     * @param i элемент который удаляется
     * @return в случае успешного удаления возвращает true
     */
    public Boolean deleteNum(T i) {
        if (i == null) return false;
        return arr.remove(i);
    }

    /**
     * Переопределяет метод ObjectBox
     * В случае добавления элемента не наследующего Number генерирует исключение IllegalArgumentException
     *
     * @param obj обьект который необходимо добавить в коллекцию
     * @return в случае успешного добавления элемента в коллекцию возвращает true иначе false
     */
    @Override
    protected Boolean addObject(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Number) {
            return super.addObject(obj);
        } else {
            throw new IllegalArgumentException("Не верный аргумент");
        }
    }
