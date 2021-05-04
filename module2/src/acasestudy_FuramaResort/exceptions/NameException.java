package acasestudy_FuramaResort.exceptions;

public class NameException extends Exception {
    public NameException() {
        super("The first letter must be upper case. ");
    }
}
