package servlet;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "servlet.CustomerServlet", urlPatterns = "")
public class CustomerServlet extends HttpServlet {
   ArrayList<Customer> list=new ArrayList<>();
    @Override
    public void init() throws ServletException {
     list.add(new Customer("Mai Văn Hoàn","20-08-1983","Hà Nội","https://tinshowbiz.com/wp-content/uploads/2018/03/no-luc-thoat-khoi-hinh-anh-nguoi-mau-dong-phim-cua-truong-my-nhan-2.jpg"));
     list.add(new Customer("Mai Văn ","20-08-1983","Hà Nội","https://tinshowbiz.com/wp-content/uploads/2018/03/no-luc-thoat-khoi-hinh-anh-nguoi-mau-dong-phim-cua-truong-my-nhan-2.jpg"));
     list.add(new Customer("Mai ","20-08-1983","Hà Nội","https://tinshowbiz.com/wp-content/uploads/2018/03/no-luc-thoat-khoi-hinh-anh-nguoi-mau-dong-phim-cua-truong-my-nhan-2.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("customer",list);
     request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
