import engine.Calculator;
import engine.MathExpression;
import io.ConsoleIO;
import io.Input;
import io.Output;

import java.util.Optional;

public class CalculatorApplication {
    private static final Input input = new ConsoleIO();
    private static final Output output = new ConsoleIO();
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        output.printHelp();
        while(true) {
            String userInput = input.getExpression();

            if (userInput.equalsIgnoreCase("EXIT"))
                System.exit(0);

            Optional<MathExpression> expression = createExpression(userInput);
            if (expression.isEmpty()) continue;

            int result = calculator.calcExpression(expression.get());
            output.printResult(result);
        }
    }

    private static Optional<MathExpression> createExpression(String userInput) {
        try{
            return Optional.of(new MathExpression(userInput));
        } catch (IllegalArgumentException e) {
            output.printIllegalInputFormatError();
            return Optional.empty();
        }
    }
}
