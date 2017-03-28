public class LNode {

    private int Lcar;
    private LNode Lcdr;

    public LNode() {

    }

    public LNode(int car) {
        this.Lcar = car;
        this.Lcdr = new LNode();
    }

    public LNode(int car, LNode cdr) {
        this.Lcar = car;
        this.Lcdr = cdr;
    }

    public int car() {
        return this.Lcar;
    }

    public LNode cdr() {
        return this.Lcdr;
    }

    public void setCar(int e) {
        this.Lcar = e;
    }

    public void setCdr(LNode n) {
        this.Lcdr = n;
    }

    public boolean hasNext() {
        return Lcdr != null;
    }

    public LNode next() {
        return this.Lcdr;
    }

}
