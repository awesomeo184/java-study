package engine.validator;

@FunctionalInterface
public interface ExpressionValidator {
    boolean isInvalidExpression(String expression);
}
