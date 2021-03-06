package acasestudy_FuramaResort.Commons;

import acasestudy_FuramaResort.exceptions.BirtdayException;
import acasestudy_FuramaResort.exceptions.GenderException;

import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class Validators {
    public static final String SERVICE_CODE_REGEX = "SV(VL||HO||RO)-[\\d]{4}";
    public static final String SERVICE_NAME_REGEX = "[A-Z][a-z]*";
    public static final String ID_CARD_REGEX = "[\\d]{3} [\\d]{3} [\\d]{3}";
    public static final String AGE_REGEX = "^[\\d]{1,3}$";




    public static String checkBirthDay() {
        String regexDayFormat = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        String input = null;
        boolean check;
        do {
            try {
                input = new Scanner(System.in).nextLine();
                int birthYear = Integer.parseInt(input.split("/")[2]);
                int currentYear = Year.now().getValue();
                if (!input.matches(regexDayFormat)) {
                    throw new Exception();
                } else if (birthYear <= 1900 || currentYear - birthYear < 18) {
                    throw new Exception();
                }
                System.out.println("Amazing good job job job ");
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Lêu lêu nhập sai rồi nhé nhập lại đi! ");
                check = true;
            }
        } while (check);
        return input;
    }


//    public static void main(String[] args) {
//        while (true){
//            System.out.println(new Scanner(System.in).nextLine().matches(REGEX_VIETNAMESE_NAME));
//        }
//    }

    public static final String REGEX_EMAIL = "^(.+)[\\@](.+)([\\.][a-z]+)+$";
    public static final String REGEX_VIETNAMESE_NAME = "^([\\s]*[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]+)+(([A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]*))*$";
    public static final String REGEX_DAY_FORMAT = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static boolean isValidRegex(String str, String regex) {
        boolean flag = str.matches(regex);
        if (!flag) {
            System.out.println("Input not matching: " + regex);
        }
        return flag;
    }

    public static boolean isMoreThan(double number, double desNumber) {
        boolean flag = number > desNumber;
        if (!flag) {
            System.out.println("Input not more than " + desNumber);
        }
        return flag;
    }

    public static boolean isMoreThan(double number, double startNumber, double endNumber) {
        boolean flag = number > startNumber & number < endNumber;
        if (!flag) {
            System.out.println("Input not in(" + startNumber + ", " + endNumber + ")");
        }
        return flag;
    }

    public static boolean isValiExtraServiceName(String extraServiceName) {
        String[] list = {"massage", "karaoke", "food", "drink", "car"};
        boolean flag = Arrays.asList(list).contains(extraServiceName);
        if (!flag) {
            System.out.println("Extra service name is not in list service");
        }
        return flag;
    }

    public static String isValidGender(String gender) throws GenderException {
        String[] list = {"male", "female", "unknown"};
        if (!Arrays.asList(list).contains(gender.toLowerCase())) {
            throw new GenderException();
        } else {
            ConvertUltils.normalizeStr(gender);
        }
        return gender;
    }

    public static String checkExceptionInput(String property, String regex, Exception exception) {
        String nhapThuocTinh;
        do {
            try {
                System.out.println(property);
                nhapThuocTinh = new Scanner(System.in).nextLine();
                if (!nhapThuocTinh.matches(regex)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println(exception.getMessage());
                System.err.println("Error format: " + regex + "\nTry again: ");
            }
        } while (true);
        return nhapThuocTinh;
    }


    public static void isValidBirthday(String birthDay) throws BirtdayException {
        if (isValidRegex(birthDay, Validators.REGEX_DAY_FORMAT)) {
            int birthYear = Integer.parseInt(birthDay.split("/")[2]);
            int curYear = Year.now().getValue();

            if (birthYear <= 1900 || curYear - birthYear < 18) {
                throw new BirtdayException();
            }
        } else {
            throw new BirtdayException();
        }
    }

}

