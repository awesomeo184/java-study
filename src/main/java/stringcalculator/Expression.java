package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Expression {

    private static final List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "/", "*"));
    private static final int MIM_LENGTH = 3;
    private final Queue<String> elements = new LinkedList<>();

    public Expression(String input) {
        String[] splicedExpression = input.split(" ");
        removeBlank(splicedExpression);
        validate(splicedExpression);
        elements.addAll(Arrays.asList(splicedExpression));
    }

    private void validate(String[] expression) {

        if (expression.length < MIM_LENGTH) {
            throw new IllegalArgumentException("피연산자는 두 개 이상, 연산자는 한 개 이상이어야 합니다.");
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

    /*
    * 첫 번째 인자는 반드시 숫자여야하고, 숫자와 연산자는 번갈아 등장해야하므로 연산자는 항상 홀수 인덱스에 나타나야한다.
    * */
    private boolean isOperatorPosition(int i) {
        return i % 2 != 0;
    }

    private void assertOperatorFormat(String target) {
        if (!isOperator(target)) {
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

    public int evaluate() {

        Stack<Integer> stack = new Stack<>();

        while (!elements.isEmpty()) {
            String elem = elements.poll();

            if (isOperator(elem)) {
                int first = stack.pop();
                int second = Integer.parseInt(elements.poll());
                stack.push(calculate(elem, first, second));
                continue;
            }

            stack.push(Integer.parseInt(elem));
        }

        return stack.pop();
    }

    private boolean isOperator(String elem) {
        return operators.contains(elem);
    }

    private int calculate(String operator, int first, int second) {
        if (operator.equals("+")) {
            return first + second;
        }

        if (operator.equals("-")) {
            return first - second;
        }

        if (operator.equals("/")) {
            return first / second;
        }

        if (operator.equals("*")) {
            return first * second;
        }

        throw new IllegalArgumentException("처리할 수 없는 연산자 = " + operator);
    }
}
