public class StringCalculatorExc {
    static StringCalculator calculator;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        calculator=new StringCalculator();
        while (calculator.checkswitch()) {
            calculator.excution();
        }

    }

}