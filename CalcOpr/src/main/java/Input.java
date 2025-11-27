import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/input")
public class Input extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter pr = response.getWriter();

        pr.println("<html> <body>" +
                "<br/>" +
                "<form action='calc' >" +
                "<label>first number:</label> <input type='text' name='v1'> <br/>" +
                "<label>second number:</label> <input type='text' name='v2'> <br/>" +
                "<label>Operation:</label>" +
                "<select name='operation'>" +
                "<option value='+'> + </option>" +
                "<option value='-'> - </option>" +
                "<option value='*'> * </option>" +
                "<option value='/'> / </option>" +
                "</select>" +
                "<br/>" +
                "<input type='submit' value='Get Result'>" +
                "</form>" +
                "</body>    " +
                "</html>");




    }
}
