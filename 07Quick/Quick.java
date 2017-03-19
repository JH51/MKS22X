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

    static int[] sort(int[] data) {
	return sort(data, 0, data.length - 1);
    }

    static int[] sort(int[] data, int start, int end) {
	if (Math.abs(start - end) <= 1) return data;
	if (start < end) {
	    int pivot = part(data, start, end);
	    sort(data, start, pivot);
	    sort(data, pivot, end);
	}
	return data;
    }

    static int part2(int[] data, int start, int end) {
	int pivot = new Random().nextInt(end - start + 1) + start,
	    pElement = data[pivot], 
	    sTemp = start,
	    eTemp = end;
	int[] dTemp = new int[data.length];
	for (int i = start; i < end; i += 1) {
	    if (data[i] <= pElement) {
		dTemp[sTemp] = data[i];
		sTemp += 1;
	    }
	    if (data[i] > pElement) {
		dTemp[eTemp] = data[i];
		eTemp -= 1;
	    }
	}
	return sTemp;
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
	return pivot;
    }

    public static void main(String[] args) {
	int[] ary = {2, 10, 15, 23, 0,  5};
	System.out.println(select(ary, 0));
	System.out.println(select(ary, 1));
	System.out.println(select(ary, 2));
	System.out.println(select(ary, 3));
	System.out.println(select(ary, 4));
	System.out.println(select(ary, 5));
	sort(ary);
	for (int i : ary) System.out.print(i + " ");
    }
    
}
