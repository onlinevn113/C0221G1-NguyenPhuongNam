package controller;

import model.bean.Service;
import model.service.IServiceService;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IServiceService iServiceService=new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String serviceName=request.getParameter("serviceName");
        int serviceArea=Integer.parseInt(request.getParameter("serviceArea"));
        int serviceCost=Integer.parseInt(request.getParameter("serviceCost"));
        int serviceMaxPeople=Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeId=Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId=Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom=request.getParameter("standardRoom");
        String descriptionOtherConvenience=request.getParameter("descriptionOtherConvenience");
        int poolArea=Integer.parseInt(request.getParameter("poolArea"));
        int numberOfFloors=Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service=new Service(serviceName,serviceArea,serviceCost,serviceMaxPeople,rentTypeId,serviceTypeId,
                standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors);

        try {
            request.setAttribute("message","Create is success");
            iServiceService.create(service);
            request.getRequestDispatcher("/view/service/create.jsp").forward(request,response);
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
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            default:
                showListService(request,response);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/service/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/service/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
