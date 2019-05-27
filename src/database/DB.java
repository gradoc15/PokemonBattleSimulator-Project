/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class DB
{
    private static DB instance;
    private Connection con;
    
    private DB() throws SQLException
    {
     
        try
        {
          con = DriverManager.getConnection("jdbc:postgresql://localhost/pokemon_battle_simulator", "postgres", "postgres");
        }
        catch(SQLException ex)
        {
            
            createDB();
            con = DriverManager.getConnection("jdbc:postgresql://localhost/pokemon_battle_simulator", "postgres", "postgres");
            createTables();
            
        }
        
        instance = this;
    }
    
    private void  createDB() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "postgres");
        Statement st = con.createStatement();
        
        st.executeUpdate("CREATE DATABASE pokemon_battle_simulator");
        con.close();
        System.out.println("done");
    }
    
    private void createTables() throws SQLException
    {
        System.out.println("Create Tables");
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE pokemon"
                + " ("
                + " PID INTEGER PRIMARY KEY,"
                + " NAME VARCHAR(30),"
                + " BasicHP INTEGER,"
                + " BasicATK INTEGER,"
                + " BasicDEF INTEGER,"
                + " BasicSPATK INTEGER,"
                + " BasicSPDEF INTEGER,"
                + " BasicINIT INTEGER);");
        
        st.executeUpdate("CREATE TABLE type"
                + " ("
                + " Bez VARCHAR(15) PRIMARY KEY);");
        
        
        st.executeUpdate("CREATE TABLE ability"
                + " ("
                + " AID INTEGER PRIMARY KEY,"
                + " Bez VARCHAR(30));");
        
        st.executeUpdate("CREATE TABLE move"
                + " ("
                + " MID INTEGER PRIMARY KEY,"
                + " Bez VARCHAR(30),"
                + " Type VARCHAR(15),"
                + " Category VARCHAR(30),"
                + " Power INTEGER,"
                + " Accurance INTEGER);");
        
        
        
        st.executeUpdate("CREATE TABLE pokemontype"
                + " ("
                + " PID INTEGER,"
                + " Bez VARCHAR(30),"
                + " PRIMARY KEY(PID, Bez));");
        
        
//        st.executeUpdate("ALTER TABLE pokemontype ADD CONSTRAINT fk_pokemontype_pokemon"
//                    + " FOREIGN KEY (PID) REFERENCES pet(PID);");
        
        st.executeUpdate("CREATE TABLE pokemonability"
                + " ("
                + " PID INTEGER,"
                + " AID INTEGER,"
                + " PRIMARY KEY(PID, AID));");
        System.out.println("##################");
        st.executeUpdate("CREATE TABLE pokemonmove"
                + " ("
                + " PID INTEGER,"
                + " MID INTEGER,"
                + " PRIMARY KEY(PID, MID));");
    }
    
    public static DB getInstance() throws SQLException
    {
        if(instance == null)
            instance = new DB();
        return instance;
    }
    
}
