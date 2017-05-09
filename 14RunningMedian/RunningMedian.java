public class RunningMedian {

    private MyHeap min, max;

    public RunningMedian() {
        min = new MyHeap(true);
        max = new MyHeap(false);
    }

    public void add(int i) {
        System.out.print(i + "  ->  " + this);
        if (i <= getMedian())
            max.add(i);
        else
            min.add(i);
        System.out.print(" -> " + this);
        while (min.size() > max.size() + 1) {
            max.add(min.peek());
            System.out.print(" -> " + this);
        }
        while (max.size() > min.size() + 1) {
            min.add(max.remove());
            System.out.print(" -> " + this);
        }
        System.out.println();
    }

    public double getMedian() {
        if (min.size() == max.size() && min.size() != 0)
            return ((double) min.peek() + (double) max.peek()) / 2.0;
        if (min.size() != max.size())
            return (min.size() > max.size()) ? (double) min.peek() : (double) max.peek();
        return 0.0;
    }

    public String toString() {
        String s = max + "  " + getMedian() + "  " + min;
        return s;
    }

    public static void main(String[] args) {
        RunningMedian m = new RunningMedian();
        int[] a = new int[] {1,2,3,4,5,6,7,8,9};
        for (int i : a)
            m.add(i);
        System.out.println(m.getMedian());
        System.out.println(m);
    }

}
