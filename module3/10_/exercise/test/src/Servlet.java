import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/calculator")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            double a = Double.parseDouble(request.getParameter("firstNum"));
            double b = Double.parseDouble(request.getParameter("secondNum"));
            String o = request.getParameter("operator");
            double c = 0;
            if (!(c==0 && o.equals("/"))){
                switch (o) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                }

                request.setAttribute("result",c);
                request.getRequestDispatcher("result.jsp").forward(request,response);
            } else {
                response.getWriter().println("<h1> by zero </h1>");
                throw new ArithmeticException();
            }
        }catch (ArithmeticException e){
            e.getMessage();
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
