import java.util.*;

public class Select {

    int quickSelect(int[] data, int k) {
	return quickselect(data, 0, G.length - 1, k - 1);
    }
    
    int quickSelect(int[] data, int start, int end, int k) {
	if (start <= end) {
	    int pivot = part(data, start, end);
	    if (pivot == k) return data[k];	    
	    if (pivot > k) return quickSelect(data, start, end - 1, k);
	    return quickSelect(data, pivot + 1, end, k);
	}
	return data[k];
    }
    
    int part(int[] data, int start, int end) {
	int pivot = new Random().nextInt(end - start + 1) + start;
	int temp = data[end];
	data[end] = data[pivot];
	data[pivot] = temp;
	for (int i = start; i < end; i += 1) {
	    if (data[i] > data[end]) {
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

    public static void main(String[] args) {
	int[] a = {5, 4, 3, 7, 4, 6, 1, 2};
	System.out.println(quickSelect(a, 2));
    }
    
}
