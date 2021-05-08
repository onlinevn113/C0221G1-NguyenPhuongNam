package quan_ly_phuong_tien.common;

import javax.swing.*;
import java.time.Year;
import java.util.Scanner;

public class RegexAndException {
    public RegexAndException() {
    }

    public static final String RegexAlphaber = "^[a-zA-Z]+$";
    public static final String RegexNumber = "^[\\d]+$";
    public static final String RegexEmail = "^(.+)[\\@](.+)([\\.][a-z]+)+$";
    public static final String RegexPhoneNumber84 = "^(\\+84)(-)[1-9][0-9]{8}$";
    public static final String RegexPhoneNumber0 = "^(0)[0-9]{9}$";
    public static final String RegexDayFormat = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String RegexVietNameseName = "^([\\s]*[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]+)+(([A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]*))*$";
    static Scanner scanner = new Scanner(System.in);

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

    public static String kiemTraNhapVao(String thuocTinh, String regex, String tinNhan) {
        String nhap = null;
        JOptionPane jOptionPane = new JOptionPane();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhập " + thuocTinh);
                nhap = scanner.nextLine();
                if (!nhap.matches(regex)) {
                    throw new Exception();
                }
                return nhap;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(tinNhan+"\nVui lòng nhập lại: ");
            }
        }
    }


    public static void main(String[] args) {
        kiemTraNhapVao("tên", RegexVietNameseName, "Nhập sai tên");
    }

    public static String kiemTraNhapVaoTheoDinhDang(String thuocTinh, String regex, String tinNhan, String dinhDang)  {
        String nhap = null;


        while (true) {
            try {
                System.out.println("Nhập " + thuocTinh);
                nhap = scanner.nextLine();
                if (!nhap.matches(regex)) {
                    throw new MessageException("");
                }
                return nhap;
            } catch (MessageException e) {
                System.err.println(tinNhan + "\nVui lòng nhập lại theo định dạng: " + dinhDang);
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





    //method bị bug cần được fix!
//    public static String kiemTraNhapVaoTheoDinhDang1(String thuocTinh, String regex, String tinNhan,String dinhDang) {
//        String nhap = null;
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            try {
//                System.out.println("Nhập " + thuocTinh);
//                nhap = scanner.nextLine();
//                if (!nhap.matches(regex)) {
//                    JOptionPane jOptionPane=new JOptionPane();
//                    jOptionPane.showMessageDialog(jOptionPane,tinNhan,"Lỗi",JOptionPane.ERROR_MESSAGE);
//                    throw new MessageException(tinNhan+"\nVui lòng nhập lại theo định dạng: "+dinhDang);
//                }
//                return nhap;
//            } catch (MessageException e) {
//                System.err.println(e.getMessage());
//            }
//        }
//    }

}
