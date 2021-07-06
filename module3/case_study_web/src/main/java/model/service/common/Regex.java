package model.service.common;

public class Regex {
    public static final String IDCUSTOMER = "^KH-(\\d){4}$";
    public static final String IDSERVICE = "^DV-(\\d){4}$";
    public static final String PHONENUMBER = "^((090(\\d){7})||(091(\\d){7})||(\\(84\\)\\+90(\\d){7})){1}$";
    public static final String IDCARD = "^((\\d){12}||(\\d){9}){1}$";
    public static final String NAME="^[\\p{L} .'-]+$";
    public static final String DATE = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
            + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
    public static void main(String[] args) {
        String a="^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
                + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
        String idCard = "^((\\d){12}||(\\d){9}){1}$";
        System.out.println("Nguyễn Phương Nam".matches(NAME));
    }
}
