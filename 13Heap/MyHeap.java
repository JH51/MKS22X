import java.util.*;

public class MyHeap {

    private int minMax;
    private ArrayList<String> a;

    public MyHeap() {
	a = new ArrayList<String>(1);
	minMax = 1;
    }
    
    public MyHeap(boolean b) {
	a = new ArrayList<String>(1);
	minMax (b) ? -1 : 1;
    }

    void add(String s) {
	a.add(s);
	int i = i.size() - 1;
	while (minMax * a.get(i).compareTo(a.get(i) / 2)) {
	    i = pushUp(i);
	}
    }
    
    String remove() {

    }

    String peek() {
	return a.get(1);
    }
	
    private int pushUp(int i) {
	String temp = a.get(i);
	a.set(i, a.get(i / 2));
	a.set(i / 2, temp);
	return i / 2;
    }

    private pushDown() {

    }

	}
