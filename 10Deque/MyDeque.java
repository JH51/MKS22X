import java.util.*;

public class MyDeque {

    private LinkedList<String> list;

    public MyDeque() {
        list = new LinkedList<String>();
    }

    void addFirst(String string) {
        if (string == null) throw new NullPointerException();
        list.addFirst(string);
    }

    void addLast(String string) {
        if (string == null) throw new NullPointerException();
        list.addLast(string);
    }

    String removeFirst() {
        if (this.list.size() == 0) throw new NoSuchElementException();
        return list.remove(0);
    }

    String removeLast() {
        if (this.list.size() == 0) throw new NoSuchElementException();
        return list.remove(list.size() - 1);
    }

    String getFirst() {
        if (this.list.size() == 0) throw new NoSuchElementException();
        return list.get(0);
    }

    String getLast() {
        if (this.list.size() == 0) throw new NoSuchElementException();
        return list.get(list.size() - 1);
    }

}
