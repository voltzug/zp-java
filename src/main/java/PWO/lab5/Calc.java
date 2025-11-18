package PWO.lab5;

public class Calc {
    public int multiply(int a, int b) {
        return a * b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }

    public double square(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Square < zero is not allowed");
        }
        return Math.sqrt(a);
    }
}
