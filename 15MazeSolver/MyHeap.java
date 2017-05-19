import java.util.*;

public class MyHeap {

    private int minMax;
    private ArrayList<String> a;

    public MyHeap() {
        a = new ArrayList<Location>(0);
        minMax = 1;
    }

    public MyHeap(boolean b) {
        a = new ArrayList<Location>(0);
        minMax = (b) ? -1 : 1;
    }

    void add(Location l) {
        a.add(l);
        int i = a.size() - 1;
        while (minMax * a.get(i).compareTo(a.get(i / 2)) > 0 && i > 0)
            i = pushUp(i);
        return;
    }

    String remove() {
        Location l = a.get(0);
        a.set(0, a.get(a.size() - 1));
        a.remove(a.size() - 1);
        int i = 0;
        while (i * 2 + 1 < a.size() &&
                !isValid())
            i = pushDown(i);
        return l;
    }

    Location peek() {
        return (a.size() > 0) ? a.get(0) : "";
    }

    private int pushUp(int i) {
        Location l = a.get(i);
        a.set(i, a.get(i / 2));
        a.set(i / 2, l);
        return i / 2;
    }

    private int pushDown(int i) {
        Location l = a.get(i);
        int j = i * 2 + 1;
        if (j + 1 < a.size())
            j = (minMax * a.get(i * 2 + 1).compareTo(a.get(i * 2 + 2)) >= 0) ? 1 : 2;
        a.set(i, a.get(i * 2 + j));
        a.set(i * 2 + j, l);
        return i * 2 + j;
    }

    public boolean isValid() {
        boolean b = true;
        for (int i = 0; i < a.size() && b; i += 1)
            b = minMax * a.get(i).compareTo(a.get(i / 2)) <= 0;
        return b;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < a.size(); i += 1)
            s += a.get(i) + ", ";
        return s.substring(0, s.length() - 2) + "]";
    }

	//;

}
