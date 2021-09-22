package engine;

import java.util.stream.IntStream;

public class MathExpression {
    private final String expression;

    public MathExpression(String expression) {
        validateLength(expression.split(" ").length);
        validateFormat(expression.split(" "));
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    private void validateLength(int length) {
        if (length < 3)
            throw new IllegalArgumentException("must contain more than 3 elements");
    }

    private void validateFormat(String[] expression) {
        boolean invalid = IntStream.range(0, expression.length).anyMatch(i ->
            (i % 2 != 0 && invalidOperator(expression[i])) || (i % 2 == 0) && invalidNumber(expression[i]));

        if (invalid)
            throw new IllegalArgumentException("invalid expression format");
    }

    private boolean invalidNumber(String maybeNum) {
        var NUMERIC_PATTERN = "^[1-9]\\d*$";
        return !maybeNum.matches(NUMERIC_PATTERN);
    }

    private boolean invalidOperator(String maybeOperator) {
        return !Operators.contains(maybeOperator);
    }
}
