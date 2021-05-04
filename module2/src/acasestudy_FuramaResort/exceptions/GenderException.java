package acasestudy_FuramaResort.exceptions;

public class GenderException extends Exception {
    public GenderException() {
        super("Gender must be male, female or another. ");
    }
}
