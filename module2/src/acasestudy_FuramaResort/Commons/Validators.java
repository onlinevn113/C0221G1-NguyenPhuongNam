package acasestudy_FuramaResort.Commons;

import afinal_test.commons.ExceptionValidate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Validators {
    public static final String SERVICE_CODE_REGEX = "SV(VL||HO||RO)-[\\d]{4}";
    public static final String SERVICE_NAME_REGEX = "[A-Z][a-z]*";

    public static final String RegexVietNameseName = "^([A-Z][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]?)+$";
    public  static final String RegexDayFormat="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static boolean isValidService(String str, String regex) {
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

    public static String checkExceptionInput(String property, String regex, Exception exception){
        String nhapThuocTinh;
        do {
            try {
                System.out.println("Enter: "+property);
                nhapThuocTinh = new Scanner(System.in).nextLine();
                if(!nhapThuocTinh.matches(regex)){
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println(exception.getMessage());
                System.err.println("Error format: " + regex+"\nTry again: ");
            }
        }while (true);
        return nhapThuocTinh;
    }
}

