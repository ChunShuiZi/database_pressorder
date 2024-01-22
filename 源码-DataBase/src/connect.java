import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connect {
    public static Connection getConnection() throws SQLException{
        String url="jdbc:mysql://localhost:3306/press";
        String user="root";
        String password="0214";
        return DriverManager.getConnection(url,user,password);
    }
}
