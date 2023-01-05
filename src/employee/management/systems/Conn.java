
package employee.management.systems;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            //1. Register the Driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2. Creating the connection String
            c=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "123456");
            //3. Creating statement
            s=c.createStatement();
            //4. Executing mysql queries
            
            //5. Closing the connections
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
