public class MyLinkedList {

    private LNode start, end;
    private int size;

    public MyLinkedList() {

    }

    public MyLinkedList(int[] data) {
        start = new LNode();
        for (int i = data.length - 1; i >= 0; i -= 1) {
            this.addToStart(data[i]);
            end = start.cdr();
        }
        for (int i = size; i > 0; i -= 1) end = end.cdr();
        this.size = data.length;
    }

    public MyLinkedList(int[] data, int size) {
        for (int i = 0; i < size; i += 1) this.add(data[i]);
        this.size = size;
    }

    public LNode get(int i) {
        LNode n = this.start;
        while (i > 0) {
            n = n.cdr();
            i -= 1;
        }
        return n;
    }

    public void addToStart(int element) {
        start = new LNode(element, this.start);
        size += 1;
    }

    public void add(int element) {
        end = new LNode(end.car(), new LNode(element, new LNode()));
        end = end.cdr();
        size += 1;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        String s = this.toString("", this.start);
        return (s.length() > 2) ? s.substring(0, s.length() - 2) : s;
    }

    private String toString(String s, LNode n) {
        if (! n.hasNext()) return "";
        else s += n.car() + ", " + this.toString("", n.cdr());
        return s;
    }

    public static void main(String[] args) {
        LNode n = new LNode(0, new LNode(1, new LNode(2)));
        System.out.println(n);
        int[] a = {0, 1, 2, 3, 4};
        MyLinkedList l = new MyLinkedList(a);
        System.out.println(l);
        for (int i : a) System.out.print(i + ", ");
    }

}
