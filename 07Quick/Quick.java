import java.util.*;

public class Quick {

    static int select(int[] data, int k) {
	return select(data, 0, data.length - 1, k - 1);
    }
    
    static int select(int[] data, int start, int end, int k) {
	if (start <= end) {
	    int pivot = part(data, start, end);
	    if (pivot > k) return select(data, start, end - 1, k);
	    if (pivot < k) return select(data, pivot + 1, end, k);
	}
	return data[k];
    }
    
    static int part(int[] data, int start, int end) {
	int pivot = new Random().nextInt(end - start) + start;
	int temp = data[end];
	data[end] = data[pivot];
	data[pivot] = temp;
	for (int i = start; i < end; i += 1) {
	    if (data[i] < data[end]) {
		temp = data[i];
		data[i] = data[start];
		data[start] = temp;
		start += 1;
		for (int j = 0; j < data.length; j += 1) System.out.print(data[j] + " ");
		//System.out.println(" " + pivot + ":" + data[pivot]);
	    }
	}
	temp = data[start];
	data[start] = data[end];
	data[end] = temp;
	return start;
    }

    public static void main(String[] args) {
	int[] a = {5, 4, 3, 7, 6, 1, 2};
	System.out.println(select(a, 3));
    }
    
}
