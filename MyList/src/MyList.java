public class MyList<T> implements MyCollection<T> {

    private class Node<E> {
        private E inf;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.inf = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + inf;
        }
    }

    private Node<T> head;
    private Node<T> last;
    private int size;

    public MyList() {
        head = null;
        last = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null)
            head = node;
        else
            last.next = node;

        last = node;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.inf;
    }

    @Override
    public boolean remove(T value) {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        Node<T> curr = head;
        Node<T> prev = head;

        while (curr.next != null || curr == last) {
            if (curr.inf.equals(value)) {
                if (size == 1) {
                    head = null;
                    last = null;
                }
                else if (curr.equals(head)) {
                    head = head.next;
                }
                else if (curr.equals(last)) {
                    last = prev;
                    last.next = null;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = prev.next;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        Node<T> item = head;
        for (int i = 0; i < size; i++) {
            if (item.inf.equals(value)){
                return true;
            }
            item = item.next;
        }
        return false;
    }

    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder s = new StringBuilder();
        s.append('[');
        while(true) {
            T item = current.inf;
            s.append(item);
            current = current.next;
            if (current == null)
                return s.append(']').toString();
            s.append(',').append(' ');
        }
    }
}