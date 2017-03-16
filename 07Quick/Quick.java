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
	int p = new Random().nextInt(end - start + 1) + start;
	int pElement = data[p];
	int[] temp = new int[data.length];
	for (int i = start; i < end; i += 1) {
	    if (data[i] < data[element) {
		temp[start] = data[i];
		start += 1;
	    }
	    if (data[i] > temp[end]) {
		
    
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
    
}
