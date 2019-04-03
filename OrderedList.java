public interface OrderedList {
    void add(Integer value);
    int find(Integer value);
    Integer removeAtIndex(Integer index);
    Integer get(Integer index);
    int size();
}
