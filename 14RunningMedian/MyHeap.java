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
        while (minMax * a.get(i) > a.get(i / 2) && i > 0)
            i = pushUp(i);
        return;
    }

    int remove() {
        int temp = a.get(0);
        a.set(0, a.get(a.size() - 1));
        a.remove(a.size() - 1);
        int i = 0;
        while (i * 2 + 2 < a.size() &&
               (minMax * a.get(i) < a.get(2 * i + 1) ||
	        minMax * a.get(i) < a.get(2 * i + 2)))
            i = pushDown(i);
        return temp;
    }

    int peek() {
        return a.get(0);
    }

    private int pushUp(int i) {
        int s = a.get(i);
        a.set(i, a.get(i / 2));
        a.set(i / 2, s);
        return i / 2;
    }

    private int pushDown(int i) {
        int s = a.get(i);
        int j = (a.get(i * 2 + 1) >= a.get(i * 2 + 2)) ? 1 : 2;
        a.set(i, a.get(i * 2 + j));
        a.set(i / 2, s);
        return i * 2 + j;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < a.size(); i += 1)
            s += a.get(i) + ", ";
        return s.substring(0, s.length() - 2) + "]";
    }

    public static void main(String[] args) {
        MyHeap h = new MyHeap();
        int[] s = new int[] {0, 8, 6, 4, 2, 9, 7, 5, 3, 1};
        for (int i : s) {
            h.add(i);
            System.out.println(h);
        }
        System.out.println(h.remove());
        System.out.println(h);
    }

}