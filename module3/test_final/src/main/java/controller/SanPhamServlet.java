package controller;

import model.bean.DanhMuc;
import model.bean.SanPham;
import model.service.ISanPhamService;
import model.service.impl.SanPhamImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SanPhamServlet", urlPatterns = {"", "/sanPham"})
public class SanPhamServlet extends HttpServlet {
    ISanPhamService iSanPhamService = new SanPhamImpl();


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
            case "search":
                search(request, response);
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
                showList(request, response, null);
                break;
        }
    }


    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        int gia = Integer.parseInt(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String mauSac = request.getParameter("mauSac");
        String moTa = request.getParameter("moTa");
        int danhMuc = Integer.parseInt(request.getParameter("danhMuc"));
        SanPham sanPham = new SanPham(id, ten, gia, soLuong, mauSac, moTa, danhMuc);
        boolean check = iSanPhamService.edit(sanPham);
        List<DanhMuc> danhMucs=iSanPhamService.findByAllDanhMuc();
        if (check) {
            request.setAttribute("message", "sửa thanh cong");
        } else {
            request.setAttribute("message", "sửa that bai");
            request.setAttribute("danhMucs",danhMucs);
            request.setAttribute("sanPham",sanPham);
        }
        try {
            request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        List<SanPham> sanPhams = iSanPhamService.findByName(request.getParameter("nameS"));
        List<DanhMuc> danhMucs = iSanPhamService.findByAllDanhMuc();
        request.setAttribute("sanPhams", sanPhams);
        request.setAttribute("danhMucs", danhMucs);
        try {
            request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void create(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten");
        int gia=Integer.parseInt(request.getParameter("gia"));
        int soLuong=Integer.parseInt(request.getParameter("soLuong"));
        String mauSac = request.getParameter("mauSac");
        String moTa = request.getParameter("moTa");
        int danhMuc=Integer.parseInt(request.getParameter("danhMuc"));
        SanPham sanPham=new SanPham(ten,gia,soLuong,mauSac,moTa,danhMuc);
        boolean check= iSanPhamService.create(sanPham);
        if (check) {
            request.setAttribute("message","them thanh cong");
        }else {
            request.setAttribute("message","them that bai! kiem tra lai");
        }
        try {
            request.getRequestDispatcher("/view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        SanPham sanPham = iSanPhamService.findById(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher dispatcher;
        List<DanhMuc> danhMucs=iSanPhamService.findByAllDanhMuc();
        if ( sanPham == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("danhMucs", danhMucs);
            request.setAttribute("sanPham", sanPham);
            dispatcher = request.getRequestDispatcher("/view/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idSanPham"));
        SanPham sanPham = iSanPhamService.findById(id);
        String message;
        if (sanPham == null) {
            try {
                request.getRequestDispatcher("/error-404.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            message = iSanPhamService.delete(id) ? "xoa thanh cong" : "xoa that bai!! kiem tra lai";
            showList(request, response, message);
        }

    }


    private void showList(HttpServletRequest request, HttpServletResponse response, String message) {
        List<SanPham> sanPhams = iSanPhamService.findByAll();
        List<DanhMuc> danhMucs = iSanPhamService.findByAllDanhMuc();
        request.setAttribute("sanPhams", sanPhams);
        request.setAttribute("danhMucs", danhMucs);
        request.setAttribute("message", message);
        try {
            request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<DanhMuc> danhMucs = iSanPhamService.findByAllDanhMuc();
            request.setAttribute("danhMucs", danhMucs);
            request.getRequestDispatcher("/view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
