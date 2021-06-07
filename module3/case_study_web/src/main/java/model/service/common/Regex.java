package model.service.common;

public class Regex {
    public static final String IDCUSTOMER="KH-(\\d){4}";
    public static final String IDSERVICE= "^DV-(\\d){4}$";
    public static final String PHONENUMBER="((090(\\d){7})||(091(\\d){7})||(\\(84\\)\\+90(\\d){7})){1}";
    public static final String IDCARD="()";
    public static void main(String[] args) {
        String test="(\\d{})";
        System.out.println("tfghjygh".matches(IDSERVICE));
    }
}
