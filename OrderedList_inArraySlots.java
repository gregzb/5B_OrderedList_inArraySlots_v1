public class OrderedList_inArraySlots implements OrderedList{
    List_inArraySlots<Integer> internalList;

    public OrderedList_inArraySlots() {
        internalList = new List_inArraySlots<>();
    }

    public OrderedList_inArraySlots(OrderedList_inArraySlots oldList) {
        internalList = new List_inArraySlots<>();
    }

    public void add(Integer value) {
        if (internalList.size() == 0) {
            internalList.add(value, 0);
            return;
        }
        internalList.add(value, getInsertIndex(0, internalList.size() - 1, value));
    }

    private int getInsertIndex(int start, int end, Integer value) {
        if (start == end) {
            return value < get(start) ? start : start + 1;
        }
        int mid = (end + start) / 2;
        if (value <= get(mid)) {
            return getInsertIndex(start, mid, value);
        } else {
            return getInsertIndex(mid+1, end, value);
        }
    }

    public int find(Integer value) {
        return find(0, internalList.size() - 1, value);
    }

    private int find(int start, int end, Integer value) {
        if (start == end) {
            return value == get(start) ? start : -1;
        }
        int mid = (end + start) / 2;
        if (value <= get(mid)) {
            return find(start, mid, value);
        } else {
            return find(mid+1, end, value);
        }
    }

    public void remove(Integer value) {
        internalList.remove(find(value));
    }

    public Integer removeAtIndex(Integer index) {
        Integer temp = get(index);
        internalList.remove(index);
        return temp;
    }

    public Integer set(Integer index, Integer value) {
        Integer temp = removeAtIndex(index);
        add(value);
        return temp;
    }

    public Integer get(Integer index) {
        return internalList.get(index);
    }

    public int size() {
        return internalList.size();
    }

    public String toString() {
        return internalList.toString();
    }
}
