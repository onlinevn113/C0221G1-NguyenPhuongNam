package controller;

import model.bean.*;
import model.repository.EmployeeRepository;
import model.service.IEmployeeService;
import model.service.impl.EmployeeSeviceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService iEmployeeService = new EmployeeSeviceImpl();
    //    ------------------------------------
    EmployeeRepository employeeRepository = new EmployeeRepository();
    List<Division> divisionList = employeeRepository.findByAllDivision();
    List<Position> positionList = employeeRepository.findByAllPosition();
    List<EducationDegree> educationDegreeList = employeeRepository.findByAllEducationDegree();
    List<User> userList = employeeRepository.findByAllUser();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                search(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFromCreate(request, response, null);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            default:
                showListEmployee(request, response, null);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = iEmployeeService.findById(employeeId);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            employee.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
            employee.setEmployeeName(request.getParameter("employeeName"));
            employee.setEmployeeBirthday(request.getParameter("employeeBirthday"));
            employee.setEmployeeIdCard(request.getParameter("employeeIdCard"));
            employee.setEmployeeSalary(Double.parseDouble(request.getParameter("employeeSalary")));
            employee.setEmployeePhone(request.getParameter("employeePhone"));
            employee.setEmployeeEmail(request.getParameter("employeeEmail"));
            employee.setEmployeeAddress(request.getParameter("employeeAddress"));
            employee.setPositionId(Integer.parseInt(request.getParameter("position")));
            employee.setEducationDegreeId(Integer.parseInt(request.getParameter("education")));
            employee.setDivisonId(Integer.parseInt(request.getParameter("division")));
            employee.setUserName(request.getParameter("user"));
            iEmployeeService.edit(employeeId, employee);

            request.setAttribute("message", "Edit is success");
            request.setAttribute("employee", employee);
            request.setAttribute("divisionList", divisionList);
            request.setAttribute("positionList", positionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("userList", userList);
            dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = iEmployeeService.findById(id);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("employee", employee);
            request.setAttribute("divisionList", divisionList);
            request.setAttribute("positionList", positionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("userList", userList);
            dispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int division = Integer.parseInt(request.getParameter("divisionId"));
        String userName = request.getParameter("userName");
        Employee employee = new Employee(employeeName, employeeBirthday, employeeIdCard,
                employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, division, userName);
        try {
            iEmployeeService.create(employee);
            request.setAttribute("message", "Create employee is success");
            request.setAttribute("divisionList", divisionList);
            request.setAttribute("positionList", positionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showListEmployee(HttpServletRequest request, HttpServletResponse response, String message) {
        try {
            List<Employee> employees = iEmployeeService.findByAll();
            request.setAttribute("employees", employees);
            request.setAttribute("divisionList", divisionList);
            request.setAttribute("positionList", positionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = iEmployeeService.findById(employeeId);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            boolean check = iEmployeeService.delete(employeeId);
            String message;
            if (check) {
                message = "Delete is success";
            } else {
                message = "Delete is fail";
            }
            showListEmployee(request, response, message);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameS = request.getParameter("nameS");
        List<Employee> employees = iEmployeeService.findByName(nameS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        request.setAttribute("employees", employees);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFromCreate(HttpServletRequest request, HttpServletResponse response, String message) {
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("/view/employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
