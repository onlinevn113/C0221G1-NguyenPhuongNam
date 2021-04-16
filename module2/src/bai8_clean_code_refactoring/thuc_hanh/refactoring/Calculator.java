package bai8_clean_code_refactoring.thuc_hanh.refactoring;

public class Calculator {
    public static void main(String[] args) {

    }
    public static int calculate(int firstOperand, int secondOperand, char operator) {

//        public static
        final char ADDITION = '+';
//        public static
        final char SUBTRACTION = '-';
//        public static
        final char MULTIPLICATION = '*';
//        public static
        final char DIVISION = '/';

        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}