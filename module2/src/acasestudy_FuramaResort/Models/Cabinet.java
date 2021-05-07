package acasestudy_FuramaResort.Models;

import acasestudy_FuramaResort.Controllers.MainController;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Cabinet {
    private static Stack<Employee> employeeStack = new Stack<>();

    static {
        Map<String, Employee> employeeMap = MainController.readAllEmployees(MainController.EMPLOYEE);

        for (Map.Entry<String, Employee> employeeEntry : employeeMap.entrySet()) {
            employeeStack.push(employeeEntry.getValue());
        }
    }

    private static Employee getFileOfEmployee(String id) {
        Employee employee = null;
        while (!employeeStack.empty()) {
            employee = employeeStack.pop();
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return employee;
    }

    public static void findFileOfEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input employee id to get file: ");
        String id = scanner.nextLine();
        Employee employee = getFileOfEmployee(id);
        if (employee != null) {
            System.out.println("File employee "+employee.toString());
        }else {
            System.out.println("File employee is not found!");
        }
    }
}
