package mypkg1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {

    private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user="system";
    private static final String key="admin";

   public static Connection dbCon () throws SQLException, ClassNotFoundException {


            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(url,user,key);

       if(conn!=null) System.out.println("Connection Success!\n");
       else System.out.println("Connection fail!");


       return conn;
   }


}
