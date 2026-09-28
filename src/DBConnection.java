import java.sql.*;
public class DBConnection {
    public static Connection getConnection(){
        Connection con=null;
        try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        con=DriverManager.getConnection("jdbc:mysql://localhost/ccitdb", "root", "admin");
        }
        catch(Exception er){
            System.out.println("ERROR: "+er);
        }
        return con;
    }
}
