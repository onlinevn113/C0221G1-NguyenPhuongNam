package afinal_test.commons;

import javax.xml.validation.Validator;
import java.time.Year;
import java.util.Scanner;

public class ExceptionValidate {
    public ExceptionValidate() {
    }


    public static final String RegexEmail = "^(.+)[\\@](.+)([\\.][a-z]+)+$";
    public static final String RegexPhoneNumber84 = "^(\\+84)(-)[1-9][0-9]{8}$";
    public static final String RegexPhoneNumber0 = "^(0)[0-9]{9}$";
    public static final String RegexDayFormat = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String RegexVietNameseName = "^([\\s]*[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]+)+(([A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]*))*$";


    public static String kiemTraNgayThangNamSinh() {
        String kiemTraNgayNhap = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        String nhap = null;
        do {
            try {
                System.out.println("Nhập ngày tháng năm sinh muốn kiểm tra");
                nhap = new Scanner(System.in).nextLine().trim();
                int namSinh = Integer.parseInt(nhap.split("/")[2]);
                int namHienTai = Year.now().getValue();
                if (!nhap.matches(kiemTraNgayNhap)) {
                    throw new Exception();
                } else if (namSinh <= 1900 || namHienTai - namSinh < 18 || namSinh - namHienTai > 1) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Nhập sai thử lại: ");
            }
        } while (true);
        return nhap;
    }

    public static String kiemTraNhapVaoMessage(String property, String regex, String message) {
        String input = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhập " + property);
                input = scanner.nextLine();
                if (!input.matches(regex)) {
                    throw new MessageException(message);
                }
                return input;
            } catch (MessageException e) {
                e.printStackTrace();
                System.err.println("Vui lòng nhập lại: ");
            }
        }
    }

    public static String kiemTraNhapVaoNgoaiLe(String property, String regex, Exception exception) {
        String nhapThuocTinh;
        do {
            try {
                System.out.println("Nhập: " + property);
                nhapThuocTinh = new Scanner(System.in).nextLine().trim();
                if (!nhapThuocTinh.matches(regex)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(exception.getMessage());
                System.err.println("Vui lòng nhập lại:");
            }
        } while (true);
        return nhapThuocTinh;
    }


    public static void main(String[] args) {
//        while (true){
//            String a=new Scanner(System.in).nextLine();
//            System.out.println(a.matches(RegexEmail));
//        }
        kiemTraNhapVaoMessage("",RegexEmail , "bạn nhập sai tên");

    }
}
