import java.util.*;

public class Driver {

    public static String toString(int[] a) {
        String s = "";
        s += a[0] + ", ";
        s += a[1] + ", ";
        s += "... , ";
        s += a[a.length - 2] + ", ";
        s += a[a.length - 1] + ", ";
        return s;
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        //int cases = Integer.parseInt(args[0]);
        //int size = Integer.parseInt(args[1]);

        //a. Randomized; minVal to maxVal
        if (args[0].equals("1")) {
            int score = 0;
            int[][] a = new int[new Random().nextInt(1000)][new Random().nextInt(1000)];
            for (int[] aa : a) {
                for (int i = 0; i < aa.length; i += 1) {
                    aa[i] = new Random().nextInt(Integer.MAX_VALUE) - new Random().nextInt(Integer.MAX_VALUE);
                }
            }
            for (int[] aa : a) {
                Quick.quicksort(aa);
                if (Quick.isSorted(aa)) score += 1;
                else System.out.println("Error: " + toString(aa));
            }
            System.out.println(score + " / " + a.length);
        }

        //b. Randomized; a to b


        //c. Same values


        //d. Sorted


        //e. Reverse-sorted

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " ms");

    }

}
