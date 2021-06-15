package controller;

import model.bean.Student;
import model.service.IStudentService;
import model.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceServlet", urlPatterns = {"","/student"})
public class ServiceServlet extends HttpServlet {
    IStudentService iStudentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Student student = new Student(id, name, gender, birthday, email, address);
        RequestDispatcher dispatcher;
        Student student1 = iStudentService.findById(id);
        if (student1 == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        }
        Map<String,String> mapMsg= iStudentService.edit(student);
        try {
            if (mapMsg.isEmpty()){
                request.setAttribute("message","create is success");
                request.getRequestDispatcher("/view/edit.jsp").forward(request,response);
            }else{
                request.setAttribute("message","edit is fail!! something wrong");
                request.setAttribute("student",student);
                request.setAttribute("nameMsg",mapMsg.get("nameMsg"));
                request.setAttribute("genderMsg",mapMsg.get("genderMsg"));
                request.setAttribute("birthdayMsg",mapMsg.get("birthdayMsg"));
                request.setAttribute("emailMsg",mapMsg.get("emailMsg"));
                request.setAttribute("addressMsg",mapMsg.get("addressMsg"));
                request.getRequestDispatcher("/view/edit.jsp").forward(request,response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Student student = new Student(name, gender, birthday, email, address);
        Map<String,String> mapMsg= iStudentService.create(student);
        try {
            if (mapMsg.isEmpty()){
                request.setAttribute("message","create is success");
                request.getRequestDispatcher("/view/create.jsp").forward(request,response);
            }else{
                request.setAttribute("message","create is fail!! something wrong");
                request.setAttribute("student",student);
                request.setAttribute("nameMsg",mapMsg.get("nameMsg"));
                request.setAttribute("genderMsg",mapMsg.get("genderMsg"));
                request.setAttribute("birthdayMsg",mapMsg.get("birthdayMsg"));
                request.setAttribute("emailMsg",mapMsg.get("emailMsg"));
                request.setAttribute("addressMsg",mapMsg.get("addressMsg"));
                request.getRequestDispatcher("/view/create.jsp").forward(request,response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameS = request.getParameter("nameS");
        List<Student> students = iStudentService.findByName(nameS);
        request.setAttribute("students", students);
        try {
            request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idStudent"));
        Student student = iStudentService.findById(id);
        String message;
        if (student == null) {
            try {
                request.getRequestDispatcher("/error-404.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            message = iStudentService.delete(id) ? "Delete is success" : "Delete is fail!! something wrong";
            showList(request, response, message);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            default:
                showList(request, response, null);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        try {
          int id= Integer.parseInt(request.getParameter("id")) ;
            Student student=iStudentService.findById(id);
            request.setAttribute("student",student);
            request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response, String message) {
        List<Student> students = iStudentService.findByAll();
        request.setAttribute("students", students);
        request.setAttribute("message", message);
        try {
            request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
