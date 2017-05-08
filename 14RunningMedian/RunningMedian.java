public class RunningMedian {

    private MyHeap min, max;
    private int size;

    public RunningMedian() {
	min = new MyHeap(true);
	max = new MyHeap(false);
	size = 0;
    }
    
    public void add(int i) {
	size += 1;
	if (i <= min.peek())
	    min.add(i);
	else
	    max.add(i);
    }

    public double getMedian() {
	if (size % 2 == 0)
	    return ((double) min.peek() + (double) max.peek()) / 2.0;
    }

}
