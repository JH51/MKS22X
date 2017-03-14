import java.util.Random;

public class QuickSelect {

    Random random = new Random();

    int select(int[] data, int k) {
	return part(data, 0, data.length - 1);
    }
    
    int part(int[] data, int start, int end) {
	int p = start
        while (start <= end) {
	    while (start <= end && nums[start] <= nums[p]) start += 1;
	    while
    }
    
    static void main(String[] args) {
	int[] a = new int[];
	a = {1, 3, 4, 5, 7, 2};
	System.out.println(select(a, 2));
    }
    
}
