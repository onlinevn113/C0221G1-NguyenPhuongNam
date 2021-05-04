package acasestudy_FuramaResort.exceptions;

public class IdCardException extends Exception {
    public IdCardException() {
        super("Id card must be 9 digists and format: XXX XXX XXX.");
    }
}
