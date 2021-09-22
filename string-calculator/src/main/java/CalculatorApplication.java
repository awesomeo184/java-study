import engine.domain.Calculator;
import engine.validator.DefaultExpressionValidator;
import engine.validator.ExpressionValidator;
import io.ConsoleIO;
import io.Input;
import io.Output;

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

            if (validator.isInvalidExpression(userInput)) {
                output.printIllegalInputFormatError();
                continue;
            }

            int result = calculator.calcExpression(userInput);
            output.printResult(result);
        }
    }
}
