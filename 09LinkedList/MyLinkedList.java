public class MyLinkedList {

    private class LNode {
	
	int car;
	LNode cdr;
	
	public LNode() {

	}

	public LNode(int car) {
	    this.car = car;
	    this.cdr = new LNode();
	}
	
	public LNode(int car, LNode cdr) {
	    this.car = car;
	    this.cdr = cdr;
	}

	public String toString() {
	    String s = "";
	    if (this.cdr != null) {
		s += this.car;
		LNode n = this.cdr;
		while (this.cdr != null) {
		    s += ", " + n.car;
		    n = n.cdr;
		}
	    }
	    return s;
	}
	
    }
    
    
    
    private LNode start, end;
    private int size;
    
    public MyLinkedList() {
	
    }

    public MyLinkedList(int[] data) {
        start = new LNode();
        for (int i = data.length - 1; i >= 0; i -= 1) {
            this.addToStart(data[i]);
            System.out.println(start + " | " + end);
        }
        end = start.cdr;
        for (int i = size; i > 1; i -= 1) end = end.cdr;
        this.size = data.length;
        System.out.println();
        System.out.println(start + " | " + end);
    }
    
    public MyLinkedList(int[] data, int size) {
        for (int i = 0; i < size; i += 1) this.add(data[i]);
        this.size = size;
    }

    public int get(int i) {
        LNode n = this.start;
        while (i > 0) {
            n = n.cdr;
            i -= 1;
        }
        return n.car;
    }

    public int set(int i, int e) {
	int tE = this.get(i);
	LNode tN = start;
	while (i > 0) {
	    tN = tN.cdr;
	    i -= 1;
	}
	tN = new LNode(e, tN.cdr);
	return tE;
    }

    public void addToStart(int element) {
        start = new LNode(element, this.start);
        size += 1;
    }

    public void add(int element) {
        end = new LNode(end.car, new LNode(element, new LNode()));
        start = new LNode(start.car, end);
        end = end.cdr;
        size += 1;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
	String s = "["; 
        s += this.toString("", this.start);
        if (s.length() > 2) s = s.substring(0, s.length() - 2);
	return s + "]";
    }

    private String toString(String s, LNode n) {
        if (n.cdr == null) return "";
        else s += n.car + ", " + this.toString("", n.cdr);
        return s;
    }

    public static void main(String[] args) {
        //LNode n = new LNode(0, new LNode(1, new LNode(2)));
        //System.out.println(n);
        int[] a = {0, 1, 2, 3, 4};
        MyLinkedList l = new MyLinkedList(a);
        System.out.println();
        //l.add(5);
        System.out.println(l);
        for (int i : a) System.out.print(i + ", ");
    }

}
