public class RunningMedian {

    private MyHeap min, max;

    public RunningMedian() {
        min = new MyHeap(true);
        max = new MyHeap(false);
    }

    public void add(int i) {
        //System.out.print(i + "  ->  " + this);
        if (i <= getMedian())
            max.add(i);
        else
            min.add(i);
        //System.out.print(" -> " + this);
        if (min.size() > max.size() + 1) {
            max.add(min.remove());
            //System.out.print(" -> " + this);
        }
        if (max.size() > min.size() + 1) {
            min.add(max.remove());
            //System.out.print(" -> " + this);
        }
        //System.out.println();
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

}
