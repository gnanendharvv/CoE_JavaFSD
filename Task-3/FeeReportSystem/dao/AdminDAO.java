package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBConnection;

public class AdminDAO {
    public static boolean validateAdmin(String username, String password) {
        String query = "SELECT * FROM admin WHERE username=? AND password=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
