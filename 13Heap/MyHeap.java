import java.util.*;

public class MyHeap {

    private int minMax;
    private ArrayList<String> a;

    public MyHeap() {
        a = new ArrayList<String>(0);
        minMax = 1;
    }

    public MyHeap(boolean b) {
        a = new ArrayList<String>(0);
        minMax = (b) ? -1 : 1;
    }

    void add(String s) {
        a.add(s);
        int i = a.size() - 1;
        while (minMax * a.get(i).compareTo(a.get(i / 2)) > 0 && i > 0)
            i = pushUp(i);
        return;
    }

    String remove() {
        String s = a.get(0);
        if (a.size() == 1)
            return a.remove(0);
        else {
            a.set(0, a.remove(a.size() - 1));
            int i = 0;
            while (i * 2 + 1 < a.size() && minMax * a.get(i).compareTo(a.get(i * 2 + 1)) <= 0)
                i = pushDown(i);
            return s;
        }
    }

    String peek() {
        return (a.size() > 0) ? a.get(0) : "";
    }

    private int pushUp(int i) {
        String s = a.get(i);
        a.set(i, a.get(i / 2));
        a.set(i / 2, s);
        return i / 2;
    }

    private int pushDown(int i) {
        String s = a.get(i);
        int j = 1;
        if (i * 2 + 2 < a.size())
            j = (minMax * a.get(i * 2 + 1).compareTo(a.get(i * 2 + 2)) >= 0) ? 1 : 2;
        a.set(i, a.get(i * 2 + j));
        a.set(i * 2 + j, s);
        return i * 2 + j;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < a.size(); i += 1)
            s += a.get(i) + ", ";
        return s.substring(0, s.length() - 2) + "]";
    }
    
}
