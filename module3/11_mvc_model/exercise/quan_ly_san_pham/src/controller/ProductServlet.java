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

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;

        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    String id=request.getParameter("id");
    Product product=productService.findById(id);
    RequestDispatcher dispatcher;
    if (product==null){
        dispatcher=request.getRequestDispatcher("/view/error-404.jsp");
    }else {
        productService.delete(id);
    }
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        }else {
            product.setName(name);
            product.setPrice(price);
            productService.update(id,product);
            request.setAttribute("product",product);
            request.setAttribute("message","Product infomation was update");
            dispatcher=request.getRequestDispatcher("/view/product/edit.jsp");

        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        Product product = new Product(id, name, price);
        productService.create(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/create.jsp");
        request.setAttribute("message", "New product was create");
        try {
            dispatcher.forward(request, response);
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
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditFrom(request, response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                viewProduct(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }
////        ----------------------------------------------------------------------------------------
//        String nameS=request.getParameter("nameS");
//        List<Product> productS=productService.findByName(nameS);
//        RequestDispatcher dispatcher;
//        if (productS==null){
//            dispatcher=request.getRequestDispatcher("/vỉew/error-404.jsp");
//        }else {
//            request.setAttribute("nameS",nameS);
//            request.setAttribute("products",productS);
//            dispatcher=request.getRequestDispatcher("/view/product/search.jsp");
//        }
//        dispatcher.forward(request,response);
    }



    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        Product product=productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null){
            dispatcher=request.getRequestDispatcher("/vỉew/error-404.jsp");
        }else {
            request.setAttribute("product",product);
            dispatcher=request.getRequestDispatcher("/view/product/view.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    String id=request.getParameter("id");
    Product product=productService.findById(id);
    RequestDispatcher dispatcher;
    if (product == null){
        dispatcher=request.getRequestDispatcher("/view/error-404.jsp");
    }else {
        request.setAttribute("product",product);
        dispatcher=request.getRequestDispatcher("/view/product/delete.jsp");
    }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFrom(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
