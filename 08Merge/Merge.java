public class Merge {

    static void mergesort(int[] a) {
        if (a.length < 2) { }
        else {
            int[] left = new int[a.length / 2], right = new int[a.length - a.length / 2];
            for (int i = 0; i < a.length / 2; i += 1) left[i] = a[i];
            for (int i = a.length / 2; i < a.length; i += 1) right[i - a.length / 2] = a[i];
            mergesort(left);
            mergesort(right);
            System.out.print("\nMERGING: ");
            for (int i : left) System.out.print(i + " ");
            System.out.print(" +  ");
            for (int i : right) System.out.print(i + " ");
            merge(left, right, a);
            System.out.print("\nRESULT:  ");
            for (int i : a) System.out.print(i + " ");
            System.out.println();
        }
        return;
    }

    /*
    static void merge(int[] a, int[] b, int[] dest) {
        dest = merge(a, b);
    }
    */

    static void merge(int[] a, int[] b, int[] dest) {
        int i = 0, j = 0, k = 0;
        while (j < a.length &&
               k < b.length) {
            if (a[j] < b[k]) {
                dest[i] = a[j];
                j += 1;
            }
            else {
                dest[i] = b[k];
                k += 1;
            }
            i += 1;
        }
        while (k == b.length && j < a.length) {
            dest[i] = a[j];
            j += 1;
            i += 1;
        }
        while (j == b.length && k < b.length) {
            dest[i] = b[k];
            k += 1;
            i += 1;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 9};
        int[] b = {2, 4, 6, 7, 8};
        int[] c = {6, 44, 74, 3, 654, 25, 8, 47, 975, 32};
        mergesort(c);
        for (int i : c) System.out.print(i + " ");
    }

}
