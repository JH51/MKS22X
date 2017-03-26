import java.util.*;

public class Driver {

    public static String toString(int[] a) {
        String s = "";
        s += a[0] + ", ";
        s += a[1] + ", ";
        s += ". . . ";
        s += a[a.length - 2];
        s += a[a.length - 1];
        return s;
    }

    public static void main(String[] args) {

        //int cases = Integer.parseInt(args[0]);
        //int size = Integer.parseInt(args[1]);

        //a. Randomized; minVal to maxVal
        int score = 0;
        int[][] a = new int[new Random().nextInt(1000)][new Random().nextInt(1000)];
        for (int[] aa : a) {
            for (int i = 0; i < aa.length; i += 1) {
                aa[i] = new Random().nextInt(1000);
            }
        }
        for (int[] aa : a) {
            Quick.quicksort(aa);
            if (Quick.isSorted(aa)) score += 1;
            else System.out.println("Error: " + toString(aa));
        }
        System.out.println(score + " / " + a.length);

        //b. Randomized; a to b


        //c. Same values


        //d. Sorted


        //e. Reverse-sorted

    }

}
