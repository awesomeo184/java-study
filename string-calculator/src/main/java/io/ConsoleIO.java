package io;

import java.util.Scanner;

public class ConsoleIO implements Input, Output{

    @Override
    public String getExpression() {
        System.out.print("Type a mathematical expression to calculate : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void printHelp() {
        System.out.println(
            """
            String Calculator
            =================
            - numbers and operators must be seperated by single space
            - type exit to exit program
            """
        );
    }

    @Override
    public void printIllegalOperatorError() {
        System.out.println("[ERROR] Illegal Operator Error");
    }

    @Override
    public void printIllegalNumberError() {
        System.out.println("[ERROR] Illegal Number Error");
    }

    @Override
    public void printIllegalInputFormatError() {
        System.out.println("[ERROR] Illegal Input Format Error");
    }

    @Override
    public void printResult(int num) {
        System.out.println(num);
    }

    @Override
    public void printExit() {
        System.out.println("Existing Program");
    }

}
