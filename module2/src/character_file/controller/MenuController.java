package character_file.controller;


import character_file.model.Student;
import character_file.service.IStudentService;
import character_file.service.ITeacherService;
import character_file.service.impl.StudentService;
import character_file.service.impl.TeacherService;

import java.util.List;
import java.util.Scanner;

public class MenuController {
    MenuController menuController = new MenuController();
    private IStudentService iStudentService = new StudentService();
    private ITeacherService iTeacherService = new TeacherService();

    public void menuAdd() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bạn muốn thêm mới: ");
            System.out.println("1. Học sinh");
            System.out.println("2. Giáo viên");
            System.out.println("3. Back");
            System.out.println("4. Exit");
            try {
                System.out.print("Mời bạn nhập lự chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        List<Student> students =  iStudentService.list();
                        menuController.showListStudent(students);
                        return;
                    case 2:
                    case 3:
                        return;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Bạn nhập lựa chon sai. Yêu cầu nhập lại!");
                }
            } catch (Exception e) {
                System.out.println("Bạn nhập lựa chon sai. Yêu cầu nhập lại!");
            }

        }
    }

    public void showListStudent(List<Student> students) {
        System.out.println("Danh sách sinh viên");
        for(int i =0; i<students.size();i++) {
            System.out.println((i+1)+". "+students.get(i));
        }
    }
}
