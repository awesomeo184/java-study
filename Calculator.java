import java.util.Scanner;

public class Calculator {

	static int calculate(int first, String symbol, int second) {
		int result = 0;
		if (symbol.equals("+")) {
			result = first + second;

		} else if (symbol.equals("-")) {
			result = first - second;

		} else if (symbol.equals("*")) {
			result = first * second;

		} else if (symbol.equals("/")) {
			result = first / second;

		} else {
			System.out.println("사칙연산 기호가 아닙니다.");
		}
		return result;
	} 
		
	
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			
	int first = Input.getFristValue(scanner);
		
	int result = first;
	while(true) {
		String symbol = Input.getSymbol(scanner);
			
		if (symbol.equals("quit")) {
			Output.print(result);
			break;
		}
			
		int second = Input.getSecondValue(scanner);
			
		result = calculate(result, symbol, second);
		}
	}

}
