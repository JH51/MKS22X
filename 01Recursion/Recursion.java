public class Recursion {

    public static String name() {
	return "Huang,Jonathan";
    }

    public static double sqrt(double n) {
	if (n < 0) throw new IllegalArgumentException();
	return sqrtHelper(n / 2, 1, n);
    }

    public static double sqrtHelper(double a, double b, double n) {
	if (Math.abs(a * a - n) / n < 0.01) return a;
	System.out.println(a + " " + a * a);
	return sqrtHelper((a / b + b) / 2, a, n);
    }

    public static void main(String[] args) {
	System.out.println(sqrt(100));
	//System.out.println(sqrt(400));
	//System.out.println(sqrt(90000));
    }
    
}
