package controller;

import model.bean.Product;
import model.service.IProductService;
import model.service.impl.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchByNameServlet" ,urlPatterns = "/search")
public class SearchByNameServlet extends HttpServlet {
    IProductService productService = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameS=request.getParameter("nameS");
        List<Product> productS=productService.findByName(nameS);
        RequestDispatcher dispatcher;
        if (productS==null){
            dispatcher=request.getRequestDispatcher("/vỉew/error-404.jsp");
        }else {
            request.setAttribute("nameS",nameS);
            request.setAttribute("products",productS);
            dispatcher=request.getRequestDispatcher("/view/product/search.jsp");
        }
        dispatcher.forward(request,response);
    }
}
