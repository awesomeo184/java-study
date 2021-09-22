import engine.calculator.Calculator;
import engine.expression_validator.DefaultExpressionValidator;
import engine.expression_validator.ExpressionValidator;
import io.ConsoleIO;
import io.Input;
import io.Output;

import java.util.Locale;

public class CalculatorApplication {
    private static final Input input = new ConsoleIO();
    private static final Output output = new ConsoleIO();
    private static final ExpressionValidator validator = new DefaultExpressionValidator();
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        output.printHelp();
        while(true) {
            var prompt = "Type a mathematical expression to calculate : ";
            String userInput = input.getInput(prompt);

            if (userInput.equalsIgnoreCase("EXIT"))
                System.exit(0);
            if (validator.isInvalidExpression(userInput))
                output.printIllegalInputFormatError();
        }
    }
}
