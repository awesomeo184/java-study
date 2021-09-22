package engine.expression_validator;

import engine.OperatorType;

import java.util.stream.IntStream;

public class DefaultExpressionValidator implements ExpressionValidator {

    public boolean isInvalidExpression(String expression) {
        var elementList = expression.split(" ");

        // 최소 연산자 1개와 숫자 2개가 필요
        if (invalidLength(elementList.length)) return true;
        // 마지막 요소는 숫자
        if (invalidNumber(elementList[elementList.length - 1])) return true;
        // 숫자와 연산자가 번갈아가며 등장
        if (invalidFormat(elementList)) return true;

        return false;
    }

    private boolean invalidLength(int length) {
        return length < 3;
    }

    private boolean invalidNumber(String maybeNum) {
        var NUMERIC_PATTERN = "^[1-9]\\d*$";
        return !maybeNum.matches(NUMERIC_PATTERN);
    }

    private boolean invalidFormat(String[] elementList) {
        return IntStream.range(0, elementList.length).anyMatch(i ->
            (i%2 != 0 && invalidNumber(elementList[i])) || (i%2 == 0) && invalidOperator(elementList[i]));
    }

    private boolean invalidOperator(String maybeOperator) {
        return !OperatorType.contains(maybeOperator);
    }
}
