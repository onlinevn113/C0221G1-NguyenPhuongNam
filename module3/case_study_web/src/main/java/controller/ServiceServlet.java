package controller;



import model.bean.RentType;
import model.bean.Service;
import model.bean.ServiceType;
import model.service.IServiceService;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IServiceService iServiceService = new ServiceServiceImpl();
    List<ServiceType> serviceTypeList = iServiceService.findByAllServiceType();
    List<RentType> rentTypeList = iServiceService.findByAllRentType();

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
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            default:
                showListService(request, response, null);
                break;
        }
    }
    private void showListService(HttpServletRequest request, HttpServletResponse response, String message) {
        List<Service> serviceList = iServiceService.findByAll();
        List<ServiceType> serviceTypeList = iServiceService.findByAllServiceType();
        List<RentType> rentTypeList = iServiceService.findByAllRentType();
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Service  service =  iServiceService.findById(id);
        RequestDispatcher dispatcher;
        if(service == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            boolean check = iServiceService.delete(id);
            String message;
            if(check){
                message ="Delete is success";
            }else {
                message = "Delete is fail";
            }
            showListService(request,response,message);
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        int serviceCost = Integer.parseInt(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        int poolArea = Integer.parseInt(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId,standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
        iServiceService.edit(id,service);
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("message","Edit is success");
        request.setAttribute("service", service);
        try {
            request.getRequestDispatcher("/view/service/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void create(HttpServletRequest request, HttpServletResponse response) {
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        int serviceCost = Integer.parseInt(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        int poolArea = Integer.parseInt(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId,
                standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
        try {
            iServiceService.create(service);
            request.setAttribute("message", "Create is success");
            request.getRequestDispatcher("/view/service/create.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        Service service = iServiceService.findById(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher dispatcher;
        if (service == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("serviceTypeList", serviceTypeList);
            request.setAttribute("rentTypeList", rentTypeList);
            request.setAttribute("service", service);
            dispatcher = request.getRequestDispatcher("/view/service/edit.jsp");
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
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        try {
            request.getRequestDispatcher("/view/service/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
