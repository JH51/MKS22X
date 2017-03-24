import java.util.*;

public class Quick {

    static int quickselect(int[] data, int k) {
        return quickselect(data, 0, data.length - 1, k);
    }

    static int quickselect(int[] data, int start, int end, int k) {
        if (start < end) {
            int[] pivot = part2(data, start, end);
            if (pivot[2] > k)
                return quickselect(data, 0, pivot[0], k);
            if (pivot[2] < k)
                return quickselect(data, pivot[1], data.length - 1, k);
        }
        return data[k];
    }

    static void quicksort(int[] data) {
        quicksort(data, 0, data.length - 1);
    }

    static void quicksort(int[] data, int start, int end) {
        if (Math.abs(start - end) <= 1) return;
        if (start <= end) {
            int[] pivot = part2(data, start, end);
            quicksort(data, start, pivot[0]);
            quicksort(data, pivot[1], end);
        }
    }

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


    static int[] part2(int[] data, int start, int end) {
        int pivot = new Random().nextInt(end - start + 1) + start,
            p = data[pivot],
            i = start,
            j = end;
        swap(data, pivot, end);
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
        //for (int x : data) System.out.print(x + " ");
        int[] a = {start, end, pivot};
        return a;
    }

    static int[] swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
        return data;
    }

    static boolean isSorted(int[] data) {
        boolean b = true;
        int i = 1;
        while (i < data.length && data.length > 1 && b) {
            b = data[i] >= data[i - 1];
            i += 1;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] ary = {2, 10, 10, 10, 10, 10, 15, 23, 23, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 5, 5};

        System.out.println(quickselect(ary, 0));
        System.out.println(quickselect(ary, 1));
        System.out.println(quickselect(ary, 2));
        System.out.println(quickselect(ary, 3));
        System.out.println(quickselect(ary, 4));
        System.out.println(quickselect(ary, 5));

        quicksort(ary);
        for (int i = 0; i < ary.length; i += 1) System.out.print(ary[i] + " ");
        System.out.println(isSorted(ary));
    }

}
