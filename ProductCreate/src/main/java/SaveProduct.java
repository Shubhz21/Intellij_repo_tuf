import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/saveproduct")
public class SaveProduct extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response){

        boolean result = false;

        response.setContentType("text/html");

        try{
            PrintWriter pr2 = response.getWriter();
            PreparedStatement ps2 = DbCon.getConnected().prepareStatement("select table_name from user_tables where table_name='PRODUCTS'");
            ResultSet rs = ps2.executeQuery();

             result = rs.next();

            if(!result){
                pr2.println("Table not Found!!...new table creation in progress...!");
                try{


                    PreparedStatement ps3 = DbCon.getConnected().prepareStatement("create table products (id int, name varchar(255),price int, quantity int)");
                   int effect =  ps3.executeUpdate();

                   pr2.println("Table Created success!");

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }


        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("pname");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {   PrintWriter pr = response.getWriter();
            PreparedStatement ps = DbCon.getConnected().prepareStatement("insert into products values (?, ?, ?, ?)");
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,price);
            ps.setInt(4,quantity);
            int effect = ps.executeUpdate();

            if(effect>0)
                pr.println("<p>Product saved success! </p>");
            else pr.println("operation fail!");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (IOException io){
            throw  new RuntimeException(io);
        }


    }

}
