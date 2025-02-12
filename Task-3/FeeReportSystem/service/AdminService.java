package service;
import dao.AdminDAO;

public class AdminService {
    public static boolean login(String username, String password) {
        return AdminDAO.validateAdmin(username, password);
    }
}
