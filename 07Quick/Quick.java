import java.util.*;

public class Quick {

    static int quickselect(int[] data, int k) {
        return quickselect(data, 0, data.length - 1, k);
    }

    static int quickselect(int[] data, int start, int end, int k) {
        if (start <= end) {
            int pivot = part(data, start, end);
            if (pivot > k) return quickselect(data, start, end - 1, k);
            if (pivot < k) return quickselect(data, pivot + 1, end, k);
        }
        return data[k];
    }

    static int[] quicksort(int[] data) {
        return quicksort(data, 0, data.length - 1);
    }

    static int[] quicksort(int[] data, int start, int end) {
        if (Math.abs(start - end) <= 1) return data;
        if (start < end) {
            int pivot = part(data, start, end);
            quicksort(data, start, pivot);
            quicksort(data, pivot, end);
        }
        return data;
    }

    /*
    static int part(int[] data, int start, int end) {
        int pivot = new Random().nextInt(end - start + 1) + start;
        swap(data, pivot, end);
        for (int i = start; i < end; i += 1) {
            if (data[i] < data[end]) {
                swap(data, start, i);
                start += 1;
            }
        }
        swap(data, start, end);
        return pivot;
    }
    */

    static int part(int[] data, int start, int end) {
        int pivot = new Random().nextInt(end - start + 1) + start;
        swap(data, pivot, end);
        int p = data[pivot];
        int i = start;
        while (i <= end) {
            if (data[i] == p) {
                i += 1;
            }
            else if (data[i] < p) {
                swap(data, start, i);
                start += 1;
                i += 1;
            }
            else if (data[i] > p) {
                swap(data, i, end);
                end -= 1;
            }
        }
        return pivot;
    }

    static int[] swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
        return data;
    }

    public static void main(String[] args) {
        int[] ary = {2, 10, 15, 23, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

        System.out.println(quickselect(ary, 0));
        System.out.println(quickselect(ary, 1));
        System.out.println(quickselect(ary, 2));
        System.out.println(quickselect(ary, 3));
        System.out.println(quickselect(ary, 4));
        System.out.println(quickselect(ary, 5));

        quicksort(ary);
        for (int i : ary) System.out.print(i + " ");
        System.out.println("");
    }

}
