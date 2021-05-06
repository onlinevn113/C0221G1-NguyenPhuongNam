package commons;

import java.util.Scanner;

public class CanBoException extends Exception {
    public static String tenTiengViet = "^([A-ZÁ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]?)+$";

    public CanBoException() {
    }

    public CanBoException(String message) {
        super(message);
    }

    public static String namSinh = "^[1|2][0-9]{3}$";
    public static String diaChi = "^([A-Z][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]?)+$";
    public static String kiemTraCapBac= "^[1-7]/7$";



    public static String kiemTraNhapVaoMessage(String property, String regex, String message) {
        String input = null;
        Scanner scanner=new Scanner(System.in);
        while (true){
            try {
                System.out.println("Nhập " + property);
                input = scanner.nextLine();
                if (!input.matches(regex)) {
                    throw new CanBoException(message);
                }
                return input;
            } catch (CanBoException e) {
                e.printStackTrace();
                System.err.println("Vui lòng nhập lại: ");
            }
        }
    }
}
