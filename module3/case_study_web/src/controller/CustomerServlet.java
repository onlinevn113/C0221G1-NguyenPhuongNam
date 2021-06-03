package controller;

import model.bean.Customer;
import model.service.ICustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    ICustomerService iCustomerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:

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
                showListCustomer(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameS=request.getParameter("nameS");
        List<Customer> customers = iCustomerService.findByName(nameS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        request.setAttribute("customers", customers);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idCustomer=Integer.parseInt(request.getParameter("id"));
        int idTypeCustomer=Integer.parseInt(request.getParameter("idTypeCustomer"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String sex = request.getParameter("sex");
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("namphoneNumbere");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(idTypeCustomer, name, dateOfBirth, sex, idCard, phoneNumber, email, address);
        boolean check=iCustomerService.edit(idCustomer,customer);
        if (check){
            request.setAttribute("message","Edit is success");
        }else {
            request.setAttribute("message","Edit is fail something wrong");
        }
        request.setAttribute("customer",customer);
        try {
            request.getRequestDispatcher("/view/customer/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
            request.setAttribute("customer", customer);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idTypeCustomer = Integer.parseInt(request.getParameter("idTypeCustomer"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String sex = request.getParameter("sex");
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("namphoneNumbere");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(idTypeCustomer, name, dateOfBirth, sex, idCard, phoneNumber, email, address);
        try {
            boolean check = iCustomerService.create(customer);
            String message;
            if (check) {
                message = "create is success";
            } else {
                message = "create is fail\nsomething wrong!!";
            }
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = iCustomerService.findByAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        request.setAttribute("customers", customers);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idCustomer"));
        iCustomerService.delete(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
