public class MyLinkedList {

    private class LNode {

        int value;
        LNode previous, next;

        public LNode() {

        }

        public LNode(int value) {
            this.value = value;
        }

        public LNode(int value, LNode next) {
            this.value = value;
            this.next = next;
        }

        public String toString() {
            String s = "";
            if (this.next != null) {
                s += this.value;
                LNode n = this.next;
                while (this.next != null) {
                    s += ", " + n.value;
                    n = n.next;
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
        end = new LNode();
        for (int i = data.length - 1; i >= 0; i -= 1) {
            this.addToStart(data[i]);
        }
        this.size = data.length;
    }

    public MyLinkedList(int[] data, int size) {
        for (int i = 0; i < size; i += 1) this.add(data[i]);
        this.size = size;
    }

    public int get(int i) {
        LNode n = this.start;
        while (i > 0) {
            n = n.next;
            i -= 1;
        }
        return n.value;
    }

    public int set(int i, int e) {
        int tE = this.get(i);
        LNode tN = start;
        while (i > 0) {
            tN = tN.next;
            i -= 1;
        }
        tN = new LNode(e, tN.next);
        return tE;
    }

    public void addToStart(int e) {
        start = new LNode(e, this.start);
        size += 1;
    }

    public void add(int element) {
        if (this.size == 0) start = new LNode(element);
        else {
            LNode tempNode = start;
            while (tempNode.next != null) tempNode = tempNode.next;
            tempNode.next = new LNode(element);
        }
        size +=  1;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        String string = "[";
        LNode tempNode = start;
        while (tempNode.next != null) {
            string += tempNode.value + ", ";
            tempNode = tempNode.next;
        }
        if (string.length() > 1) string = string.substring(0, string.length() - 2);
        return string + "]";
    }

    public static void main(String[] args) {
        //LNode n = new LNode(0, new LNode(1, new LNode(2)));
        //System.out.println(n);
        int[] a = {0, 1, 2, 3, 4};
        MyLinkedList l = new MyLinkedList(a);
        System.out.println();
        //l.add(5);
        l.set(1, 10);
        System.out.println(l);
        for (int i : a) System.out.print(i + ", ");
    }

}
