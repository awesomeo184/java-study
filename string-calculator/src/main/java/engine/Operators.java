package engine;

import java.util.Arrays;

public enum Operators {
    PLUS("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
    };

    private final String OPERATOR;

    Operators(String operator) {
        this.OPERATOR = operator;
    }

    private String getOperator() {
        return OPERATOR;
    }

    public static boolean contains (String operator) {
        return Arrays.stream(Operators.values())
            .anyMatch(op -> operator.equals(op.getOperator()));
    }

    public static Operators operatorOf(String operator) {
        return Arrays.stream(Operators.values())
            .filter(op -> operator.equals(op.getOperator()))
            .findAny().get();
    }

    public abstract int calculate(int a, int b);
}
