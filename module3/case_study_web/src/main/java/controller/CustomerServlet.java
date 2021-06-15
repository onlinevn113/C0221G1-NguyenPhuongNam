package controller;

import model.bean.*;
import model.service.ICustomerService;
import model.service.ITypeCustomerService;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.TypeCustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    ICustomerService iCustomerService = new CustomerServiceImpl();

    ITypeCustomerService iTypeCustomerService = new TypeCustomerService();

    public List<CustomerType> customerTypes = iTypeCustomerService.findAllCustomerType();


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
                showListCustomer(request, response, null);
                break;
        }
    }



    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameS = request.getParameter("nameS");
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
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = iCustomerService.findById(customer_id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            customer.setIdTypeCustomer(Integer.parseInt(request.getParameter("customer_type_id")));
            customer.setName(request.getParameter("customer_name"));
            customer.setDateOfBirth(String.valueOf(request.getParameter("customer_birthday")));
            customer.setSex(Integer.parseInt(request.getParameter("customer_gender")));
            customer.setIdCard(request.getParameter("customer_id_card"));
            customer.setPhoneNumber(request.getParameter("customer_phone"));
            customer.setEmail(request.getParameter("customer_email"));
            customer.setAddress(request.getParameter("customer_address"));
            iCustomerService.edit(customer_id, customer);
            request.setAttribute("message", "Edit is success");
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypes", customerTypes);
            dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
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
        Customer customer = iCustomerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypes", customerTypes);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerTypes", customerTypes);
        try {
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = String.valueOf(request.getParameter("customerBirthday"));
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);

        try {
            Map<String, String> mapMsg= iCustomerService.create(customer);
            if (mapMsg.isEmpty()){
                request.getRequestDispatcher("view/customer/create.jsp").forward(request,response);
                request.setAttribute("message", "Create customer is success");
                request.setAttribute("customerTypes", customerTypes);
            }else {
                request.setAttribute("customerTypes", customerTypes);
                request.setAttribute("customerFail",customer);
                request.setAttribute("nameMsg",mapMsg.get("name"));
                request.setAttribute("dateOfBirthMsg",mapMsg.get("dateOfBirth"));
                request.setAttribute("idCardMsg",mapMsg.get("idCard"));
                request.setAttribute("phoneNumberMsg",mapMsg.get("phoneNumber"));
                request.setAttribute("emailMsg",mapMsg.get("email"));
                request.setAttribute("addressMsg",mapMsg.get("address"));
                request.getRequestDispatcher("view/customer/create.jsp").forward(request,response);
            }


        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response, String message) {
        List<Customer> customers = iCustomerService.findByAll();
        List<CustomerType> customerTypes = iTypeCustomerService.findAllCustomerType();
        request.setAttribute("customers", customers);
        request.setAttribute("customerTypes", customerTypes);
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customer_id = Integer.parseInt(request.getParameter("idCustomer"));
        Customer customer = iCustomerService.findById(customer_id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            boolean check = iCustomerService.delete(customer_id);
            String message;
            if (check) {
                message = "Delete is success";
            } else {
                message = "Delete is fail";
            }
            showListCustomer(request, response, message);
        }
    }
}
