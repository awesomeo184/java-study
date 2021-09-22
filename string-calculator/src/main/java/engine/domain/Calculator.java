package engine.domain;

import engine.Operators;

public class Calculator {

    public int calcExpression(String expression) {
        var elementList = expression.split(" ");
        var operator = Operators.operatorOf(elementList[1]);
        var num1 = Integer.parseInt(elementList[0]);
        var num2 = Integer.parseInt(elementList[2]);
        var result = operator.calculate(num1, num2);

        if (elementList.length == 3)
            return result;

        for (int i = 3; i < elementList.length; i+=2) {
            operator = Operators.operatorOf(elementList[i]);
            num1 = result;
            num2 = Integer.parseInt(elementList[i+1]);
            result = operator.calculate(num1, num2);
        }
        return result;
    }
}
