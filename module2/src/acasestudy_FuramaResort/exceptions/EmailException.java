package acasestudy_FuramaResort.exceptions;

public class EmailException extends Exception {
    public EmailException() {
        super(  );
        System.err.println("Format email must be abc@abc.abc."+"\nTry again: ");
    }
}
