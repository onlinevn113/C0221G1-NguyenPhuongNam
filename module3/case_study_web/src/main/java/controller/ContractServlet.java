package controller;

import model.bean.*;
import model.repository.ContractRepository;
import model.repository.CustomerRepository;
import model.repository.EmployeeRepository;
import model.repository.ServiceRepository;
import model.service.IContractService;
import model.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    List<Contract> contractList = new ContractRepository().findByAllContract();
    List<AttachService> attachServiceList = new ContractRepository().findByAllAttachService();


    IContractService iContractService = new ContractServiceImpl();
    List<Service> serviceList = new ServiceRepository().findByAll();
    List<Employee> employeeList = new EmployeeRepository().findByAll();
    List<Customer> customerList = new CustomerRepository().findByAll();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createContract":
                createContract(request, response);
                break;
            case "createContractDetail":
                createContractDetail(request, response);
                break;
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contractId=Integer.parseInt(request.getParameter("contractId"));
        int attachServiceId=Integer.parseInt(request.getParameter("attachServiceId"));
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail=new ContractDetail(contractId,attachServiceId,quantity);
        request.setAttribute("contractList", contractList);
        request.setAttribute("attachServiceList", attachServiceList);
        request.setAttribute("message","Create Contract Detail is success");
        try {
            iContractService.createContractDetail(contractDetail);
            request.getRequestDispatcher("/view/contract/createContractDetail.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        String contractStartDate = request.getParameter("contractStartDate");
        String contractEndDate = request.getParameter("contractEndDate");
        int contractDeposit = Integer.parseInt(request.getParameter("contractDeposit"));
        int contractTotal = Integer.parseInt(request.getParameter("contractTotal"));
        Contract contract = new Contract(employeeId, customerId, serviceId, contractStartDate, contractEndDate,
                contractDeposit, contractTotal);
        request.setAttribute("message", "Create contract is success");
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("/view/contract/createContract.jsp").forward(request, response);
            iContractService.createContract(contract);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createContract":
                showFormCreateContract(request, response);
                break;
            case "createContractDetail":
                showFormCreateContractDetail(request, response);
                break;
            default:
                showListContract(request, response);
                break;
        }
    }

    private void showFormCreateContractDetail(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contractList", contractList);
        request.setAttribute("attachServiceList", attachServiceList);
        try {
            request.getRequestDispatcher("/view/contract/createContractDetail.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateContract(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("/view/contract/createContract.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListContract(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/contract/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
