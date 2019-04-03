import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 Implement a list of integer elements, including
 both data and operations.
 */

public class List_inArraySlots<T> {

    // declare fields here

    private static final int DEFAULT_SIZE = 10;

    private Object[] array;
    private int capacity;

    /**
     Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        array = new Object[DEFAULT_SIZE];
    }

    public List_inArraySlots(T[] array) {
        int startSize = DEFAULT_SIZE;
        while (startSize < array.length) {
            startSize*=2;
        }
        this.array = new Object[startSize];
        capacity = array.length;
        copy(array);
    }

    public List_inArraySlots(List_inArraySlots<T> list) {
        array = new Object[list.array.length];
        capacity = list.capacity;
        copy(list.array);
    }

    private void copy(Object[] array) {
        for (int i = 0; i < Math.min(this.array.length, array.length); i++) {
            this.array[i] = array[i];
        }
    }


    /**
     @return the number of elements in this list
     */
    public int size() {
        return capacity;
    }


    /**
     @return a string representation of this list,
     in [a,b,c,] format
     */
    public String toString() {
        String temp = "[";
        for (int i = 0; i < capacity-1; i++) {
            //temp += array[i] + (i == capacity - 1 ? "" : ", ");
            temp += array[i] + ", ";
        }
        temp += array[capacity-1] + "]";
        return temp;
    }


    /**
     Appends @value to the end of this list.
     @return true, in keeping with conventions yet to be discussed
     */
    public boolean add( T value) {
        return add(value, capacity);
    }

    public boolean addAsHead(T value) {
        return add(value, 0);
    }

    public boolean add( T value, int index) {
        if (index > capacity || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (capacity >= array.length) {
            expand();
        }

        for (int i = capacity; i > index; i--) {
            array[i] = array[i-1];
        }

        array[index] = value;
        capacity++;

        return true;
    }

    public boolean remove(int index) {
        if (index > capacity - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < capacity - 1; i++) {
            array[i] = array[i+1];
        }

        capacity--;

        return true;
    }

    public T get(int index) {
        if (index > capacity - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public boolean set(int index, T value) {
        if (index > capacity - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        array[index] = value;

        return true;
    }

    public List_inArraySlots<T> map(UnaryOperator<T> operator) {
        List_inArraySlots<T> newList = new List_inArraySlots<>(this);
        for (int i = 0; i < newList.capacity; i++) {
            T obj = (T) newList.array[i];
            newList.array[i] = operator.apply(obj);
        }
        return newList;
    }

    public List_inArraySlots<T> filter(Predicate<T> operator) {
        List_inArraySlots<T> newList = new List_inArraySlots<>(this);
        for (int i = 0; i < newList.capacity; i++) {
            T obj = (T) newList.array[i];
            if (!operator.test(obj)) {
                newList.remove(i);
                i--;
            }
        }
        return newList;
    }

    public T reduce(BiFunction<T, T, T> operator, T initializer) {
        List_inArraySlots<T> newList = new List_inArraySlots<>(this);
        T accumulator = initializer != null ? initializer : (T) newList.array[0];
        for (int i = initializer != null ? 0 : 1; i < capacity; i++) {
            T obj = (T) newList.array[i];
            accumulator = operator.apply(accumulator, obj);
        }
        return accumulator;
    }

    public int find(T obj) {
        for (int i = 0; i < capacity; i++) {
            if (array[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public int count(T obj) {
        int temp = 0;
        for (int i = 0; i < capacity; i++) {
            if (array[i].equals(obj)) {
                temp++;
            }
        }
        return temp;
    }


    /**
     Double the capacity of the List_inArraySlots,
     preserving existing data
     */
    private void expand() {
        Object[] oldArray = array;
        array = new Object[oldArray.length * 2];

        copy(oldArray);
    }
}