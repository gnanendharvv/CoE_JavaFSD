package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import util.DBConnection;

public class StudentDAO {
 
    public static int save(Student student) {
        int status = 0;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO student(name, email, course, fee, paid, due, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setDouble(4, student.getFee());
            ps.setDouble(5, student.getPaid());
            ps.setDouble(6, student.getDue());
            ps.setString(7, student.getAddress());
            ps.setString(8, student.getPhone());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

  
    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {

            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getDouble("fee"),
                    rs.getDouble("paid"),
                    rs.getDouble("due"),
                    rs.getString("address"),
                    rs.getString("phone")
                );
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

 
    public static int update(Student student) {
        int status = 0;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE student SET name=?, email=?, course=?, fee=?, paid=?, due=?, address=?, phone=? WHERE id=?")) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setDouble(4, student.getFee());
            ps.setDouble(5, student.getPaid());
            ps.setDouble(6, student.getDue());
            ps.setString(7, student.getAddress());
            ps.setString(8, student.getPhone());
            ps.setInt(9, student.getId());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

 
    public static int delete(int id) {
        int status = 0;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id=?")) {

            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    
    public static List<Student> getDueFees() {
        List<Student> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE due > 0")) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getDouble("fee"),
                    rs.getDouble("paid"),
                    rs.getDouble("due"),
                    rs.getString("address"),
                    rs.getString("phone")
                );
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
