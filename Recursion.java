public interface hw01 {
    public static String name();
    public static double sqrt(double n); 
}

public class Recursion implemements hw01 {

    public static String name() {
	return "Huang,Jonathan";
    }

    public static double sqrt(double n) {
	if (n < 0) throw new IllegalArgumentExcepton();
    }
