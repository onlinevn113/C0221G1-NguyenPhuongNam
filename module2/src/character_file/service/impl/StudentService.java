package character_file.service.impl;

import character_file.model.Student;
import character_file.service.IStudentService;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentService implements IStudentService {
    private static final String PERSON_CSV = "src/com/company/character_file/data/person.csv";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean add(Student student) {
        try {
            FileOutputStream outputStream = new FileOutputStream(PERSON_CSV, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(student.toString());
            bufferedWriter.close();
            System.out.println("Thêm mới sinh viên thành công");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(Student student, int index) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public List<Student> list() {
        List<Student> students = new ArrayList<>();
        try {
            FileReader reader = new FileReader(PERSON_CSV);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length == 5) {
                    students.add(new Student(temp[0], Integer.parseInt(temp[1]), temp[2], temp[3], Double.parseDouble(temp[4])));
                }
            }
            reader.close();
            return students;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Đọc file lỗi");
        }
        return null;
    }

    @Override
    public Student inputAddOrEdit() {
        String name;
        do {
            System.out.print("Mời bạn nhập tên của sinh viên: ");
            name = this.scanner.nextLine();
        } while (!this.checkValidateName(name));
        System.out.print("Mời bạn nhập tuổi của sinh viên: ");
        int age = Integer.parseInt(this.scanner.nextLine());
        System.out.print("Mời bạn nhập địa chỉ của sinh viên: ");
        String address = this.scanner.nextLine();
        System.out.print("Mời bạn nhập lớp của sinh viên: ");
        String classStudent = this.scanner.nextLine();
        System.out.print("Mời bạn nhập điểm của sinh viên: ");
        double point = Double.parseDouble(this.scanner.nextLine());
        Student student = new Student(name, age, address, classStudent, point);
        return student;
    }

    public boolean checkValidateName(String name) {
        if (!Pattern.matches("^[\\p{L}\\ ]+$", name)) {
            System.out.println("Bạn nhập sai định dạng tên. Yêu cầu nhập lại.");
            return false;
        }
        return true;
    }
}
