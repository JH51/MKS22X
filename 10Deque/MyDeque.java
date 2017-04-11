import java.util.*;

public class MyDeque {

    private LinkedList<String> list;

    public MyDeque() {
        list = new LinkedList<String>();
    }

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

    public static void main(String[] args) {
        MyDeque d = new MyDeque();
        d.addFirst("0");
        d.addFirst("1");
        d.addFirst("2");
        for (int i = 0; i < 3; i += 1) {
            System.out.println(d.removeFirst());
        }
    }

}
