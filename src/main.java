
import data.Pokemon;
import data.PokemonList;
import database.DB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.pkcs11.Secmod;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class main
{
    public static void main(String[] args)
    {
        Pokemon p = new Pokemon(PokemonList.BULNASAUR);
        try
        {
            database.DB db = database.DB.getInstance();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        gui.Team t = new gui.Team();
        t.setVisible(true);
    }
}
