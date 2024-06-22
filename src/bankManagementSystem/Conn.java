package bankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {

    Connection c;
    Statement s;

    // constructor
    public Conn(){
        try {

            // create connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","admin@123");

            // create connection
            s = c.createStatement();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
