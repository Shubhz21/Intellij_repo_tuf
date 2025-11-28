import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "system";
    private static final String key = "admin";


    public static Connection getConnected() throws ClassNotFoundException, SQLException {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(url, user, key);


            return conn;
    }

}