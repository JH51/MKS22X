import java.util.*;

public class StackCalc {

    static double eval(String string) {
        String[] tokens = string.split(" ");
        Stack<Double> values = new Stack<Double>();
        for (String token : tokens) {
            if (isOperation(token))
                values.push(eval(values.pop(), values.pop(), token));
            else
                values.push(Double.parseDouble(token));
        }
        return values.pop();
    }

    static boolean isOperation(String token) {
        return token.length() == 1 && (
            token.equals("+") ||
            token.equals("-") ||
            token.equals("*") ||
            token.equals("/") ||
            token.equals("%") );
    }

    static double eval(double value1, double value2, String operation) {
        switch (operation) {
            case "+": return value2 + value1;
            case "-": return value2 - value1;
            case "*": return value2 * value1;
            case "/": return value2 / value1;
            case "%": return value2 % value1;
        }
        return 0.0;
    }

}
