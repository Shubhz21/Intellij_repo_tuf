import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/input")
public class InputProduct extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response){

        response.setContentType("text/html");

        try {
            PrintWriter pr = response.getWriter();


            pr.println("<html>" +
                    "<body><br/><br/>" +
                    "<form action='saveproduct' >" +
                    "<label>productId:</label><input type='text' name='id'><br/>" +
                    "<label>productName:</label><input type='text' name='pname'><br/>" +
                    "<label>productPrice:</label><input type='text' name='price'><br/>" +
                    "<label>productQuantity:</label><input type='text' name='quantity'><br/>" +
                    "<input type='submit' value='save'>" +
                    "</form>" +
                    "</body>" +
                    "</html>");


        }catch (Exception s){
            s.printStackTrace();
        }
    }
}
