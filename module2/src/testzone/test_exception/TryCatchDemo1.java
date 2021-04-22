package testzone.test_exception;

public class TryCatchDemo1 {
    public static void main(String[] args) {

        // Bắt đầu tuyển dụng.
        System.out.println("Start Recruiting ...");
        // Kiểm tra tuổi.
        System.out.println("Check your Age");
        int age = 50;

        try {

           AgeUtils.checkAge(age);

            System.out.println("You pass!");

        } catch (TooYoungException e) {

            // Làm gì đó tại đây ..
            System.out.println("You are too young, not pass!");
            System.out.println(e.getMessage());

        } catch (TooOldException e) {
            // Làm gì đó tại đây
            System.out.println("You are too old, not pass!");
            System.out.println(e.getMessage());

        }

    }
}
