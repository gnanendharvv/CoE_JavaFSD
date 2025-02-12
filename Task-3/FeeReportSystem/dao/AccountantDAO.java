package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Accountant;
import util.DBConnection;

public class AccountantDAO {
    

	public static boolean validateAccountant(String email, String password) {
	    boolean status = false;
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement("SELECT * FROM accountant WHERE email=? AND password=?")) {

	        ps.setString(1, email);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        status = rs.next();  
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return status;
	}


    public static int save(Accountant acc) {
        int status = 0;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO accountant(name, email, phone, password) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, acc.getName());
            ps.setString(2, acc.getEmail());
            ps.setString(3, acc.getPhone());
            ps.setString(4, acc.getPassword());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    
    public static List<Accountant> getAllAccountants() {
        List<Accountant> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM accountant")) {

            while (rs.next()) {
                Accountant acc = new Accountant(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("password")
                );
                list.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public static int update(Accountant acc) {
        int status = 0;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE accountant SET name=?, email=?, phone=?, password=? WHERE id=?")) {

            ps.setString(1, acc.getName());
            ps.setString(2, acc.getEmail());
            ps.setString(3, acc.getPhone());
            ps.setString(4, acc.getPassword());
            ps.setInt(5, acc.getId());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

  
    public static int delete(int id) {
        int status = 0;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM accountant WHERE id=?")) {

            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
