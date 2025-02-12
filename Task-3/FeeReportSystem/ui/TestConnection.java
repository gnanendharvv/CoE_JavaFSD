package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fee_report?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";  
        String password = "root";  

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Database Connected Successfully!");
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" MySQL JDBC Driver Not Found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
    }
}
