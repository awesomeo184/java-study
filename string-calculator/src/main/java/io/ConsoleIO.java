package io;

import java.util.IllegalFormatException;
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
            - type HELP to see this page
            - type EXIT to exit program
            """
        );
    }

    @Override
    public void printIllegalInputFormatError(IllegalArgumentException e) {
        System.out.println("[ERROR] Illegal Input Format Error : " + e.getMessage());
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
