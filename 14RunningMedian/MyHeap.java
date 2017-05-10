import java.util.*;

public class MyHeap {

    private int minMax;
    private ArrayList<Integer> a;

    public MyHeap() {
        a = new ArrayList<Integer>(0);
        minMax = 1;
    }

    public MyHeap(boolean b) {
        a = new ArrayList<Integer>(0);
        minMax = (b) ? -1 : 1;
    }

    void add(int s) {
        a.add(s);
        int i = a.size() - 1;
        while (minMax * a.get(i).compareTo(a.get(i / 2)) > 0 && i > 0)
            i = pushUp(i);
        return;
    }

    int remove() {
        int temp = a.get(0);
        a.set(0, a.remove(a.size() - 1));
        int i = 0;
        try {
        while (//i * 2 + 1 < a.size() &&
               (minMax * a.get(i).compareTo(a.get(2 * i + 1)) < 0 ||
                minMax * a.get(i).compareTo(a.get(2 * i + 2)) < 0))
            i = pushDown(i);
        }
        catch (IndexOutOfBoundsException e) { };
        return temp;
    }

    int peek() {
        return (a.size() > 0) ? a.get(0) : 0;
    }

    private int pushUp(int i) {
        int t = a.get(i);
        a.set(i, a.get(i / 2));
        a.set(i / 2, t);
        return i / 2;
    }

    private int pushDown(int i) {
        int t = a.get(i);
        int j = (minMax * a.get(i * 2 + 1).compareTo(a.get(i * 2 + 2)) >= 0) ? 1 : 2;
        a.set(i, a.get(i * 2 + j));
        a.set(i * 2 + j, t);
        return i * 2 + j;
        /*
        int j = i * 2 + 1;
        try {
            if (minMax * a.get(j).compareTo(a.get(j + 1)) >= 0)
                j += 1;
        }
        catch (IndexOutOfBoundsException e) { };
        a.set(i, a.get(j));
        a.set(j, t);
        return j;
        */
    }

    public int size() {
        return a.size();
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
        return (s.length() > 1) ? s.substring(0, s.length() - 2) + "]" : s + "]";
    }

    public static void main(String[] args) {
        MyHeap h = new MyHeap(true);
        for (int i = 20; i >= 0; i -= 2) {
            h.add(i);
        }
        System.out.println(h);
        System.out.println(h.isValid());
    }

}
