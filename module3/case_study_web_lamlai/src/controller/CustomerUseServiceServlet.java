package controller;

import model.bean.AttachService;
import model.bean.Customer;
import model.bean.Service;
import model.repository.CustomerUseServiceRepository;
import model.service.ICustomerUseService;
import model.service.impl.CustomerUseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerUseServiceServlet", urlPatterns = "/customeruseservice")
public class CustomerUseServiceServlet extends HttpServlet {
    ICustomerUseService iCustomerUseService = new CustomerUseServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showService":
                showService(request, response);
                break;
            case "showAttachService":
                showAttachService(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showAttachService(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");
        List<AttachService> attachServices=iCustomerUseService.findByAllAttachService(id);
        request.setAttribute("name",name);
        request.setAttribute("startDate",startDate);
        request.setAttribute("endDate",endDate);
        request.setAttribute("attachServices",attachServices);
        try {
            request.getRequestDispatcher("/view/customer_use_service/listAttachService.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        List<Service> services = iCustomerUseService.findByAllService(id);
        request.setAttribute("serviceList", services);
        request.setAttribute("name", name);
        try {
            request.getRequestDispatcher("/view/customer_use_service/listService.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = iCustomerUseService.findByAllUseService();
        request.setAttribute("customers", customers);
        try {
            request.getRequestDispatcher("/view/customer_use_service/listUseService.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
