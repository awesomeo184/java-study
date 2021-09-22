import engine.Calculator;
import engine.Commands;
import engine.MathExpression;
import io.ConsoleIO;
import io.Input;
import io.Output;

import java.util.Locale;
import java.util.Optional;

public class CalculatorApplication {
    private static final Input input = new ConsoleIO();
    private static final Output output = new ConsoleIO();
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        output.printHelp();
        while(true) {
            String userInput = input.getExpression();
            if (Commands.contains(userInput)) {
                executeCommand(Commands.valueOf(userInput.toUpperCase()));
                continue;
            }

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
            output.printIllegalInputFormatError(e);
            return Optional.empty();
        }
    }

    private static void executeCommand(Commands command) {
        switch (command) {
            case EXIT -> {
                output.printExit();
                System.exit(0);
            }
            case HELP -> {
                output.printHelp();
            }
        }
    }
}
