package afinal_test.commons;

import java.util.Scanner;

public class ExceptionValidate extends Exception {
    public ExceptionValidate() {
    }

    public ExceptionValidate(String message) {
        super(message);
    }

    public static final String RegexPhoneNumber84="^(\\+84)(-)[1-9][0-9]{8}$";
    public static final String RegexPhoneNumber0="^(0)[0-9]{9}$";
    public static final String RegexVietNameseName = "^([A-Z][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*[\\s]?)+$";
    public  static final String RegexDayFormat="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";



    public static String kiemTraThuocTinhNhapVao(String property , String regex){
        String nhapThuocTinh;
        do {
            try {
                System.out.println("Nhập: " + property);
                nhapThuocTinh = new Scanner(System.in).nextLine();
//                ExceptionValidate.kiemTraDinhDang(property,nhapThuocTinh,regex);
                if(!nhapThuocTinh.matches(regex)){
                    throw new ExceptionValidate();
                }
                break;

            } catch (ExceptionValidate exceptionValidate) {
                exceptionValidate.printStackTrace();
                System.err.println("Lỗi định dạng: " + regex+"\nVui lòng nhập lại: ");
            }
        }while (true);
        return nhapThuocTinh;
    }
    public static String kiemTraNgoaiLeNhapVao(String property, String regex,Exception exception){
        String nhapThuocTinh;
        do {
            try {
                System.out.println("Nhập: " + property);
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





    public static void main(String[] args) {

//        kiemTraThuocTinhNhapVao("Tên",RegexVietNameseName);
        while (true){
            String str=new Scanner(System.in).nextLine();
            System.out.println(str.matches(RegexVietNameseName));
        }
    }
}
