package character_file.controller;

import character_file.model.Student;
import character_file.service.IStudentService;
import character_file.service.impl.StudentService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController  {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        IStudentService iStudentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chào mừng bạn đến với chương trình của chúng tôi.");
        while (true) {
            System.out.println("Menu của quý khách bào gồm:");
            System.out.println("1. Thêm mới");
            System.out.println("2. Sửa");
            System.out.println("3. Xoa");
            System.out.println("4. Danh sách");
            System.out.println("5. Tìm kiếm");
            System.out.print("Mời quý khách lựa chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    menuController.menuAdd();
                    break;
                case "2":
                   List<Student> students =  iStudentService.list();
                   menuController.showListStudent(students);
                   break;
                default:
                    System.out.println("Bạn lựa chọn sai. yêu cầu chọn lại");
            }
        }
    }
}
