public interface MyCollection<E> {
    int size();
    boolean isEmpty();
    void add(E value);
    E get(int index);
    boolean remove(E value);
    boolean contains(E value);
}