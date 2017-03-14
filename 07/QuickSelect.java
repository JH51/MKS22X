import java.util.Random;

public class QuickSelect {

    Random random = new Random();

    int select(int[] data, int k) {
	return part(data, 0, data.length - 1);
    }
    
    int part(int[] data, int start, int end) {
        int r = random.nextInt(end) + start;
	int[] temp = new int[data.length];
	part(temp, r, end);
    }
    
    static void main(String[] args) {
	int[] a = new int[];
	a = {1, 3, 4, 5, 7, 2};
	System.out.println(select(a, 2));
    }
    
}
