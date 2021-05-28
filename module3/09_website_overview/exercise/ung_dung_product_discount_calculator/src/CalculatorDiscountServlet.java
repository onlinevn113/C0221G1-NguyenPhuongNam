import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorDiscountServlet",value = "/display-discount")
public class CalculatorDiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float price= Float.parseFloat(request.getParameter("price"));
        float discount=Float.parseFloat(request.getParameter("discount"));
        double discountAmount= price * discount *0.01;
        double discountPrice=price+discountAmount;

        request.setAttribute("discountAmount",discountAmount);
        request.setAttribute("discountPrice",discountPrice);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request,response);
    }
}
