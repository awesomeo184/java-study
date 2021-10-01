package study.stringcalculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        while (true) {
            String input = receiveInput();
            ErrorChecker checker = new ErrorChecker();
            String[] tokens = input.split(" ");
            if (!checker.checkTokens(tokens)) continue;
            double result = calculator.getResult(tokens);
            System.out.println(formatResult(result));
        }
    }

    public static String receiveInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("실행할 연산을 입력해주세요:");
        String input = sc.nextLine().replaceAll("\\s+", " ");

        if (input.equals("exit")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        return input;
    }

    public static String formatResult(double result) {
        if(result == (long) result)
            return String.format("%d",(long)result);
        else
            return String.format("%s",result);
    }
}
