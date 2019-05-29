
import database.DB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class delDB {
    public static void main(String[] args) {
        try {
            database.DB db = DB.getInstance();
            db.deleteAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
}
