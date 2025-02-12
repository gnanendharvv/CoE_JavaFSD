package service;

import dao.AccountantDAO;
import model.Accountant;
import java.util.List;

public class AccountantService {
    
   
    public static boolean login(String email, String password) {
        return AccountantDAO.validateAccountant(email, password);
    }

    public static int save(Accountant acc) {
        return AccountantDAO.save(acc);
    }

    public static List<Accountant> getAllAccountants() {
        return AccountantDAO.getAllAccountants();
    }

 
    public static int update(Accountant acc) {
        return AccountantDAO.update(acc);
    }

    public static int delete(int id) {
        return AccountantDAO.delete(id);
    }
}
