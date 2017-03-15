import java.util.*;

public class Quick {

    static int select(int[] data, int k) {
	return select(data, 0, data.length - 1, k);
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
	int pivot = new Random().nextInt(end - start + 1) + start;
	int temp = data[end];
	data[end] = data[pivot];
	data[pivot] = temp;
	for (int i = start; i < end; i += 1) {
	    if (data[i] < data[end]) {
		temp = data[i];
		data[i] = data[start];
		data[start] = temp;
		start += 1;
	    }
	}
	temp = data[start];
	data[start] = data[end];
	data[end] = temp;
	return start;
    }

/*
    public static void main(String[] args) {
	int[] a = {2, 10, 15, 23, 0,  5};
	System.out.println(select(a, 0));
	System.out.println(select(a, 1));
	System.out.println(select(a, 2));
	System.out.println(select(a, 3));
	System.out.println(select(a, 4));
	System.out.println(select(a, 5));
    }
*/
    
}
