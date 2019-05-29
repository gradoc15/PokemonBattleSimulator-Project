/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import data.Ability;
import data.Move;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class DB
{
    private static DB instance;
    private Connection con;
    
    private ArrayList<data.Pokemon> pkm = new ArrayList();
    
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
            fillType();
            fillPokemon();
            fillAbility();
            fillMove();
            fillPokeTypes();
            fillPokeAbilities();
            fillPokeMoves();
            
        }
        loadPokemon();
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
    
    private void fillType() throws SQLException
    {
        Statement st = con.createStatement();
        st.execute("INSERT INTO type VALUES('normal');");
        st.execute("INSERT INTO type VALUES('fire');");
        st.execute("INSERT INTO type VALUES('water');");
        st.execute("INSERT INTO type VALUES('grass');");
        st.execute("INSERT INTO type VALUES('electric');");
        st.execute("INSERT INTO type VALUES('ice');");
        st.execute("INSERT INTO type VALUES('fighting');");
        st.execute("INSERT INTO type VALUES('poison');");
        st.execute("INSERT INTO type VALUES('ground');");
        st.execute("INSERT INTO type VALUES('flying');");
        st.execute("INSERT INTO type VALUES('psychic');");
        st.execute("INSERT INTO type VALUES('bug');");
        st.execute("INSERT INTO type VALUES('rock');");
        st.execute("INSERT INTO type VALUES('ghost');");
        st.execute("INSERT INTO type VALUES('dragon');");
        st.execute("INSERT INTO type VALUES('steel');");
        st.execute("INSERT INTO type VALUES('fairy');");
        System.out.println("filled types");
    }
    
    private void fillPokemon() throws SQLException
    {
        
        Statement st = con.createStatement();
        st.execute("INSERT INTO pokemon VALUES(1, 'Bulbasaur', 45, 49, 49, 65, 65, 45);");
        st.execute("INSERT INTO pokemon VALUES(2, 'Ivysaur', 60, 62, 63, 80, 80, 60);");
        st.execute("INSERT INTO pokemon VALUES(3, 'Venusaur', 80, 82, 83, 100, 100, 80);");
        System.out.println("filled pokemon");
    }
    
    private void fillAbility() throws SQLException
    {
        Statement st = con.createStatement();
        st.execute("INSERT INTO ability VALUES(0, 'COMMING_SOON');");
        System.out.println("filled ability");
    }
    
    private void fillMove() throws SQLException
    {
        Statement st = con.createStatement();
        st.execute("INSERT INTO move VALUES(1, 'Tackle','normal','physic',40,100);");
        System.out.println("moves filled");
    }
    
    private void fillPokeTypes() throws SQLException
    {
        Statement st = con.createStatement();
        //pid, type
        st.execute("INSERT INTO pokemontype VALUES(1,'grass');");
        st.execute("INSERT INTO pokemontype VALUES(1,'poison');");
        st.execute("INSERT INTO pokemontype VALUES(2,'grass');");
        st.execute("INSERT INTO pokemontype VALUES(2,'poison');");
        st.execute("INSERT INTO pokemontype VALUES(3,'grass');");
        st.execute("INSERT INTO pokemontype VALUES(3,'poison');");
    }
    private void fillPokeMoves() throws SQLException
    {
        Statement st = con.createStatement();
        //pid, mid
        st.execute("INSERT INTO pokemonmove VALUES(1, 1);");
        st.execute("INSERT INTO pokemonmove VALUES(2, 1);");
        st.execute("INSERT INTO pokemonmove VALUES(3, 1);");
    }
    
    private void fillPokeAbilities() throws SQLException
    {
        Statement st = con.createStatement();
        //pid, aid
        st.execute("INSERT INTO pokemonability VALUES(1,0);");
        st.execute("INSERT INTO pokemonability VALUES(2,0);");
        st.execute("INSERT INTO pokemonability VALUES(3,0);");
    }
    
    public static DB getInstance() throws SQLException
    {
        if(instance == null)
            instance = new DB();
        return instance;
    }
    
    private void loadPokemon() throws SQLException
    {
        /*
        private int id;
        private String name;
        private Values basicValues;
        private Type type1, type2;
        private Ability[] possibleAbilities;
        */
        
        PreparedStatement actorInsertStmt;
        String actorInsert = "SELECT * FROM pokemon";
        actorInsertStmt = con.prepareStatement(actorInsert);
        
        ResultSet rs = actorInsertStmt.executeQuery();
        ResultSet rsType;
        ResultSet rsAbilities;
        ResultSet rsAbility;
        
        String type1 = "none", type2 = "none"; 
        
        LinkedList<data.Ability> abilities = new LinkedList();
        int c = 0;
        
        while(rs.next())
        {
            System.out.println(rs.getInt("BasicHP"));
            
            
            actorInsert = "SELECT * FROM pokemontype WHERE "+rs.getInt("PID")+" = PID";
            actorInsertStmt = con.prepareStatement(actorInsert);
            rsType = actorInsertStmt.executeQuery();
            
            while(rsType.next())
            {
                if(c == 0)
                    type1 = rsType.getString("Bez");
                else
                    type2 = rsType.getString("Bez");
                c++;
            }
            c = 0;
            
            actorInsert = "SELECT * FROM pokemonability WHERE "+rs.getInt("PID")+" = PID";
            actorInsertStmt = con.prepareStatement(actorInsert);
            rsAbilities = actorInsertStmt.executeQuery();
            
            while(rsAbilities.next())
            {
                actorInsert = "SELECT * FROM ability WHERE "+rsAbilities.getInt("AID")+" = AID";
                actorInsertStmt = con.prepareStatement(actorInsert);
                rsAbility = actorInsertStmt.executeQuery();
                
                while(rsAbility.next())
                    abilities.add(new Ability(rsAbility.getString("Bez")));
            }

            
            data.Pokemon p = new data.Pokemon(rs.getInt("PID"), rs.getString("name"), new data.Values(rs.getInt("BasicHP"), rs.getInt("BasicATK"), rs.getInt("BasicDEF"), rs.getInt("BasicSPATK"), rs.getInt("BasicSPDEF"), rs.getInt("BasicINIT")), type1, type2, abilities.getFirst());
            pkm.add(p);
        }

    }
    
    public ArrayList<data.Pokemon> getPokemonFromDB()
    {
        return pkm;
    }
    
    public ArrayList<data.Move> getMoveListFrom(data.Pokemon pkm) throws SQLException
    {
        ArrayList<data.Move> moveList = new ArrayList();
        
        PreparedStatement actorInsertStmt;
        String actorInsert = "SELECT * FROM pokemonmove WHERE PID = "+pkm.getId();
        actorInsertStmt = con.prepareStatement(actorInsert);
        
        ResultSet rs = actorInsertStmt.executeQuery();
        ResultSet rsMove;
        while(rs.next())
        {
            actorInsert = "SELECT * FROM move WHERE MID = " + rs.getInt("MID");
            actorInsertStmt = con.prepareStatement(actorInsert);
            rsMove = actorInsertStmt.executeQuery();
            
            while(rsMove.next())
                moveList.add(new Move(rsMove.getString("Bez"), rsMove.getString("Type"), rsMove.getString("Category"), rsMove.getInt("Power"),rsMove.getInt("Accurance")));
               
        }
        
        return moveList;
    }
    
    public ArrayList<data.Ability> getAbilitiesFrom(data.Pokemon pkm) throws SQLException
    {
        ArrayList<data.Ability> abilities = new ArrayList();
        
        PreparedStatement actorInsertStmt;
        String actorInsert = "SELECT * FROM pokemonability WHERE " + pkm.getId() + " = PID";
        actorInsertStmt = con.prepareStatement(actorInsert);
        ResultSet rsAbilities = actorInsertStmt.executeQuery();
        ResultSet rsAbility;

        while (rsAbilities.next())
        {
            actorInsert = "SELECT * FROM ability WHERE " + rsAbilities.getInt("AID") + " = AID";
            actorInsertStmt = con.prepareStatement(actorInsert);
            rsAbility = actorInsertStmt.executeQuery();

            while (rsAbility.next())
            {
                abilities.add(new Ability(rsAbility.getString("Bez")));
            }
        }

        return abilities;
    }
    
}
