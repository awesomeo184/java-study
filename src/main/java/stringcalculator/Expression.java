package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Expression {

    private static final List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "/", "*"));
    private final Queue<String> elements = new LinkedList<>();

    public Expression(String input) {
        String[] splitByBlank = input.split(" ");
        removeBlank(splitByBlank);
        validate(splitByBlank);
        elements.addAll(Arrays.asList(splitByBlank));
    }

    private void validate(String[] expression) {

        if (expression.length == 0) {
            throw new IllegalArgumentException("빈 값이 입력되었습니다.");
        }

        for (int i = 0; i < expression.length; i++) {
            String elem = expression[i];
            if (i == 0 || i == expression.length - 1) {
                assertStartsAndEndsWithNumber(elem);
            }
            assertValidOrder(i, elem);
        }

    }

    private void assertStartsAndEndsWithNumber(String elem) {
        try {
            assertIntegerFormat(elem);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 형식입니다.");
        }
    }

    private void assertValidOrder(int i, String elem) {
        if (isOperatorPosition(i)) {
            assertOperatorFormat(elem);
        } else {
            assertIntegerFormat(elem);
        }
    }

    private boolean isOperatorPosition(int i) {
        return i % 2 != 0;
    }

    private void assertOperatorFormat(String target) {
        if (!operators.contains(target)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 형식입니다.");
        }
    }


    private void removeBlank(String[] rawExpr) {
        for (int i = 0; i < rawExpr.length; i++) {
            rawExpr[i] = rawExpr[i].replaceAll(" ", "");
        }
    }


    private void assertIntegerFormat(String target) {
        try {
            Integer.parseInt(target);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 피연산자는 정수여야 합니다.");
        }
    }

    public Queue<String> getElements() {
        return elements;
    }
}
