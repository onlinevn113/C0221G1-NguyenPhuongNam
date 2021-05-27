import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorDiscount",value = "/display-discount")
public class CalculatorDiscount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float price= Float.parseFloat(request.getParameter("price"));
        float discount=Float.parseFloat(request.getParameter("discount"));
        double discountAmount= price * discount *0.01;


        
//<html></html>
        double discountPrice=price+discountAmount;
        PrintWriter printWriter =response.getWriter();
        printWriter.println("<h1>"+"Discount Amount: " + discountAmount +"<br>"+
                "Discount Price :"+discountPrice+"</h1>");

    }
}
