import java.util.*;

public class MyHeap {

    private ArrayList<Location> a;

    public MyHeap() {
        a = new ArrayList<Location>(0);
    }

    void add(Location l) {
        a.add(l);
        int i = a.size() - 1;
        while (a.get(i).compareTo(a.get(i / 2)) > 0 && i > 0)
            i = pushUp(i);
        return;
    }

    Location remove() {
        Location l = a.get(0);
        if (a.size() == 1)
            return a.remove(0);
        else {
            a.set(0, a.remove(a.size() - 1));
            int i = 0;
            while (i * 2 + 1 < a.size() && a.get(i).compareTo(a.get(i * 2 + 1)) <= 0)
                i = pushDown(i);
            return l;
        }
    }

    Location peek() {
        return (a.size() > 0) ? a.get(0) : null;
    }

    private int pushUp(int i) {
        Location l = a.get(i);
        a.set(i, a.get(i / 2));
        a.set(i / 2, l);
        return i / 2;
    }

    private int pushDown(int i) {
        Location l = a.get(i);
        int j = 1;
        if (i * 2 + 2 < a.size())
            j = (a.get(i * 2 + 1).compareTo(a.get(i * 2 + 2)) >= 0) ? 1 : 2;
        a.set(i, a.get(i * 2 + j));
        a.set(i * 2 + j, l);
        return i * 2 + j;
    }

    public int size() {
        return a.size();
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < a.size(); i += 1)
            s += "(" + a.get(i).getRow() + ", " +  a.get(i).getCol() + ")";
        return s.substring(0, s.length() - 2) + "]";
    }

}
