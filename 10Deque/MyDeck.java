import java.util;

public class MyDeque {

    LinkedList<String> list;

    void addFirst(String string) {
        list.addFirst(string);
    }

    void addLast(String string) {
        list.addLast(string);
    }

    String removeFirst() {
        return list.remove(0);
    }

    String removeLast() {
        return list.remove(list.size() - 1);
    }

    String getFirst() {
        return list.get(0);
    }

    String getLast() {
        return list.get(list.size() - 1);
    }

}
