public class MyLinkedList {

    private LNode start;
    private int size;

    public MyLinkedList() {

    }

    public MyLinkedList(int[] data) {
        for (int i = 0; i < data.length; i += 1) this.add(data[i]);
        this.size = data.length;
    }

    public MyLinkedList(int[] data, int size) {
        for (int i = 0; i < size; i += 1) this.add(data[i]);
        this.size = size;
    }

    public void add(int element) {
        start = new LNode(element, this.start);
        size += 1;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        return this.toString("", this.start);
    }

    private String toString(String s, LNode n) {
        if (! n.hasNext()) return "";
        else {
            s += n.car();
            s += toString(s, n.cdr());
            return s;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4};
        MyLinkedList l = new MyLinkedList(a);
        System.out.println(l);
    }

}
