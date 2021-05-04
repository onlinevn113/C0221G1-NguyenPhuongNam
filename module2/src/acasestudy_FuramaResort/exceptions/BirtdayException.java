package acasestudy_FuramaResort.exceptions;

public class BirtdayException extends Exception {
    public BirtdayException() {
        super("Birthday more than 1900,less than current year is 18 year and format: dd/mm/yyyy.");
    }
}
