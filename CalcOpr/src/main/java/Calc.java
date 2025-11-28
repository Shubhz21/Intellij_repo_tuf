import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
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

            case '+': result= num1+num2;
            break;
            case '-': result= num1-num2;
            break;
            case '*': result= num1*num2;
            break;
            case '/': result= num1/num2;
            break;
            case '%': result= num1%num2;
            break;
            default: pr.println("please check operation!");

        }

        pr.println("<h2>Result: " + num1 + " " + Op + " " + num2 + " = " + result + "</h2>");




    }
}
