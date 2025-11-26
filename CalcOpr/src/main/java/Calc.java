import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Calc  extends HttpServlet {


    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter pr = response.getWriter();

        int num1 = Integer.parseInt(request.getParameter("v1"));
        int num2 = Integer.parseInt(request.getParameter("v2"));
        String operation = request.getParameter("operation");
        int result=0;

        char Op = operation.charAt(0);

        switch (Op){
            case '+': pr.println(result= num1+num2);
            break;
            case '-': pr.println(result= num1-num2);
            break;
            case '*': pr.println(result= num1*num2);
            break;
            case '/': pr.println(result= num1/num2);
            break;
            default: pr.println("please check operation!");
        }


        pr.println("<html> <body>" +
                "<br/>" +
                "<form action='/Code' method='service'>" +
                "<label>first number:</label> <input type='text' name='v1'> <br/>" +
                "<label>second number:</label> <input type='text' name='v2'> <br/>" +
                "<label>Operation:</label>" +
                "<select name='operation'>" +
                "<option value='add'> + </option>" +
                "<option value='sub'> - </option>" +
                "<option value='mul'> * </option>" +
                "<option value='div'> / </option>" +
                "</select>" +
                "<br/>" +
                "<input type='submit' value='Get Result'>" +
                "</form>" +
                "</body>    " +
                "</html>");

    }
}
