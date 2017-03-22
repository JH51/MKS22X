public class Recursion {

    public static String name() {
        return "Huang,Jonathan";
    }

    public static double sqrt(double n) {
        if (n <= 0) throw new IllegalArgumentException();
        return sqrtHelper(n, n);
    }

    public static double sqrtHelper(double a, double n) {
        if (Math.abs(a * a - n) / n < 0.000000000001) return a;
        return sqrtHelper((n / a + a) / 2, n);
    }

    public static void main(String[] args) {
        System.out.println(Test01.closeEnough(Math.sqrt(1024.0), sqrt(1024.0)));
    }

}
