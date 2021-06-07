package controller;

import model.bean.AttachService;
import model.bean.Contract;
import model.bean.Customer;
import model.bean.Service;
import model.service.IContractService;
import model.service.ICustomerUseService;
import model.service.IServiceService;
import model.service.impl.ContractServiceImpl;
import model.service.impl.CustomerUseServiceImpl;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
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
    IContractService iContractService = new ContractServiceImpl();
    IServiceService iServiceService=new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "deleteService":
                deleteService(request, response);
                break;
            case "editService":
                editService(request, response);
                break;
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
        int idContract=Integer.parseInt(request.getParameter("idContract"));
        int idService=Integer.parseInt(request.getParameter("idService"));
        String contractStartDate=request.getParameter("contractStartDate");
        String contractEndDate=request.getParameter("contractEndDate");
        int contractDeposit=Integer.parseInt(request.getParameter("contractDeposit"));
        int contractTotal=Integer.parseInt(request.getParameter("contractTotal"));
        Contract contract=new Contract(idService,contractStartDate,contractEndDate,contractDeposit,contractTotal);
        iContractService.edit(idContract,contract);
        List<Service> serviceList=iServiceService.findByAll();
        request.setAttribute("serviceList",serviceList);
        request.setAttribute("idContract", idContract);
        request.setAttribute("contract", contract);
        try {
            request.getRequestDispatcher("/view/customer_use_service/editService.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = iContractService.findById(id);
        RequestDispatcher dispatcher;
        if (contract == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            boolean check = iCustomerUseService.deleteServiceInContract(id);
            String message;
            if (check) {
                message = "Delete is success";
            } else {
                message = "Delete is fail";
            }
            request.setAttribute("message",message);
            showService(request,response,message);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showService":
                showService(request, response, null);
                break;
            case "showAttachService":
                showAttachService(request, response);
                break;
            case "editService":
                showFormEditService(request, response);
            default:
                showList(request, response);
                break;
        }
    }

    private void showFormEditService(HttpServletRequest request, HttpServletResponse response) {
        int idContract = Integer.parseInt(request.getParameter("idContract"));
        List<Service> serviceList=iServiceService.findByAll();
        Contract contract = iContractService.findById(idContract);
        RequestDispatcher dispatcher;
        if (contract == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("serviceList",serviceList);
            request.setAttribute("idContract", idContract);
            request.setAttribute("contract", contract);
            dispatcher = request.getRequestDispatcher("/view/customer_use_service/editService.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAttachService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        List<AttachService> attachServices = iCustomerUseService.findByAllAttachService(id);
        request.setAttribute("name", name);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        request.setAttribute("attachServices", attachServices);
        try {
            request.getRequestDispatcher("/view/customer_use_service/listAttachService.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showService(HttpServletRequest request, HttpServletResponse response, String message) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        List<Service> services = iCustomerUseService.findByAllService(id);
        request.setAttribute("idCustomer",id);
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
