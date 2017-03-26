import java.util.*;

public class Merge {

    static void mergesort(int[] a) {
        if (a.length < 2) { return; }
        else {
            int[] left = new int[a.length / 2], right = new int[a.length - a.length / 2];
            for (int i = 0; i < a.length / 2; i += 1) left[i] = a[i];
            for (int i = a.length / 2; i < a.length; i += 1) right[i - a.length / 2] = a[i];
            mergesort(left);
            mergesort(right);
            /*
            System.out.print("\nMERGING: ");
            for (int i : left) System.out.print(i + " ");
            System.out.print(" |  ");
            for (int i : right) System.out.print(i + " ");
            */
            merge(left, right, a);
            /*
            System.out.print("\nRESULT:  ");
            for (int i : a) System.out.print(i + " ");
            System.out.println();
            */
        }
        return;
    }

    /*
    static void merge(int[] a, int[] b, int[] dest) {
        dest = merge(a, b);
    }
    */

    public static void merge(int[] left, int[] right, int[] dest) {
        int i = 0, j = 0, k = 0;
        while (j < left.length && k < right.length) {
            System.out.print(left[j] + " : " + right[k] + " | ");
            for (int l : dest) System.out.print(l + " ");
            System.out.println();
            if (left[j] <= right[k]) {
                dest[i] = left[j];
                j += 1;
                i += 1;
            } else {
                dest[i] = right[k];
                k += 1;
                i += 1;
            }
        }
        while (j < left.length) {
            dest[i] = left[j];
            j += 1;
            i += 1;
        }
        while (k < right.length) {
            dest[i] = right[k];
            k += 1;
            i += 1;
        }
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
        int[] a = new int[10];
        for (int i = 0; i < a.length; i += 1) {
            a[i] = new Random().nextInt(100) - new Random().nextInt(100);
        }
        for (int i : a) System.out.print(i + " ");
        System.out.println();
        mergesort(a);
        for (int i : a) System.out.print(i + " ");
        System.out.println();
        System.out.println(isSorted(a));
        int[] b = {3, 4, -3, 2, -7, 6, 5, 5, 1};
        mergesort(b);
        for (int i : b) System.out.print(i + " ");
        System.out.println(isSorted(b));
        int[] c = new int[5];
        int[] d = {1, 5};
        int[] e = {2, 4, 3};
        merge(d, e, c);
        for (int i : c) System.out.print(i + " ");
        System.out.println(isSorted(c));
    }

}
