import java.util.*;

public class MyDeque {

    private LinkedList<String> list;

    public MyDeque() {
        list = new LinkedList<String>();
    }

    void addFirst(String string) {
        if (string == null) throw new NullPointerException();
        list.addFirst(string);
    }

    void addLast(String string) {
        if (string == null) throw new NullPointerException();
        list.addLast(string);
    }

    String removeFirst() {
        if (this.list.size() == 0) throw new NoSuchElementException();
        return list.remove(0);
    }

    String removeLast() {
        if (this.list.size() == 0) throw new NoSuchElementException();
        return list.remove(list.size() - 1);
    }

    String getFirst() {
        if (this.list.size() == 0) throw new NoSuchElementException();
        return list.get(0);
    }

    String getLast() {
        if (this.list.size() == 0) throw new NoSuchElementException();
        return list.get(list.size() - 1);
    }

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

    public static void main(String[] args) {
        System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }

}
