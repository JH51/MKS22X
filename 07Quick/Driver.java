import java.util.*;

public class Driver {

    public static String toString(int[] a) {
        String s = "";
        s += a[0] + ", ";
        s += a[1] + ", ";
        s += "... , ";
        s += a[a.length - 2] + ", ";
        s += a[a.length - 1];
        return s;
    }

    public static void main(String[] args) {

        if (args.length == 1) {
            String temp = args[0];
            args = new String[6];
            args[0] = temp;
            args[1] = "1";
            args[2] = "1";
            args[3] = "1";
            args[4] = "1";
            args[5] = "1";
        }
        if (args.length == 0) {
            args = new String[6];
            args[0] = "1000";
            args[1] = "1";
            args[2] = "1";
            args[3] = "1";
            args[4] = "1";
            args[5] = "1";
        }


        //a. Randomized; minVal to maxVal
        if (args[1].equals("1")) {
            long startTime = System.currentTimeMillis();
            int score = 0;
            int[][] a = new int[Integer.parseInt(args[0])][new Random().nextInt(1000)];
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
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Integer.MIN_VALUE to Integer.MAX_VALUE\n" +
                               "    Ex: " + toString(a[0]) + "\n" +
                               "    " + score + " / " + a.length + "\n" +
                               "    " + totalTime + " ms\n" +
                               "    " + Math.round(1000.0 * totalTime / (double)a.length) / 1000.0 + " ms / array\n");
        }

        //b. Randomized; a to b
        if (args[2].equals("1")) {
            long startTime = System.currentTimeMillis();
            int score = 0;
            int[][] a = new int[Integer.parseInt(args[0])][new Random().nextInt(1000)];
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
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("0 to 1000\n" +
                               "    Ex: " + toString(a[0]) + "\n" +
                               "    " + score + " / " + a.length + "\n" +
                               "    " + totalTime + " ms\n" +
                               "    " + Math.round(1000.0 * totalTime / (double)a.length) / 1000.0 + " ms / array\n");
        }

        //c. Repeating Value
        if (args[3].equals("1")) {
            long startTime = System.currentTimeMillis();
            int score = 0;
            int[][] a = new int[Integer.parseInt(args[0])][new Random().nextInt(1000)];
            for (int[] aa : a) {
                int r = new Random().nextInt(Integer.MAX_VALUE) - new Random().nextInt(Integer.MAX_VALUE);
                for (int i = 0; i < aa.length; i += 1) {
                    aa[i] = r;
                }
            }
            for (int[] aa : a) {
                Quick.quicksort(aa);
                if (Quick.isSorted(aa)) score += 1;
                else System.out.println("Error: " + toString(aa));
            }
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Repeating Value\n" +
                               "    Ex: " + toString(a[0]) + "\n" +
                               "    " + score + " / " + a.length + "\n" +
                               "    " + totalTime + " ms\n" +
                               "    " + Math.round(1000.0 * totalTime / (double)a.length) / 1000.0 + " ms / array\n");
        }

        //d. Sorted
        if (args[4].equals("1")) {
            long startTime = System.currentTimeMillis();
            int score = 0;
            int[][] a = new int[Integer.parseInt(args[0])][new Random().nextInt(1000)];
            for (int[] aa : a) {
                aa[0] = new Random().nextInt(Integer.MAX_VALUE) - new Random().nextInt(Integer.MAX_VALUE);
                for (int i = 0; i < aa.length - 1; i += 1) {
                    aa[i + 1] = aa[i] + 1;
                }
            }
            for (int[] aa : a) {
                Quick.quicksort(aa);
                if (Quick.isSorted(aa)) score += 1;
                else System.out.println("Error: " + toString(aa));
            }
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Sorted Values\n" +
                               "    Ex: " + toString(a[0]) + "\n" +
                               "    " + score + " / " + a.length + "\n" +
                               "    " + totalTime + " ms\n" +
                               "    " + Math.round(1000.0 * totalTime / (double)a.length) / 1000.0 + " ms / array\n");
        }

        //e. Reverse-Sorted
        if (args[5].equals("1")) {
            long startTime = System.currentTimeMillis();
            int score = 0;
            int[][] a = new int[Integer.parseInt(args[0])][new Random().nextInt(1000)];
            for (int[] aa : a) {
                aa[0] = new Random().nextInt(Integer.MAX_VALUE) - new Random().nextInt(Integer.MAX_VALUE);
                for (int i = 0; i < aa.length - 1; i += 1) {
                    aa[i + 1] = aa[i] - 1;
                }
            }
            for (int[] aa : a) {
                Quick.quicksort(aa);
                if (Quick.isSorted(aa)) score += 1;
                else System.out.println("Error: " + toString(aa));
            }
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Reverse-Sorted Values\n" +
                               "    Ex: " + toString(a[0]) + "\n" +
                               "    " + score + " / " + a.length + "\n" +
                               "    " + totalTime + " ms\n" +
                               "    " + Math.round(1000.0 * totalTime / (double)a.length) / 1000.0 + " ms / array\n");
        }

    }

}
