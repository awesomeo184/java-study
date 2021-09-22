package engine;

import java.util.Arrays;
import java.util.Optional;

public enum OperatorType {
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

    OperatorType(String operator) {
        this.OPERATOR = operator;
    }

    private String getOperator() {
        return OPERATOR;
    }

    public static boolean contains (String operator) {
        return Arrays.stream(OperatorType.values())
            .anyMatch(op -> operator.equals(op.getOperator()));
    }

    public static Optional<OperatorType> operatorOf(String operator) {
        return Arrays.stream(OperatorType.values())
            .filter(op -> operator.equals(op.getOperator()))
            .findAny();
    }

    public abstract int calculate(int a, int b);
}
