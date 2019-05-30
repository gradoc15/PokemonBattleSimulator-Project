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
    
    /**
     * Constructor, creates the database structure
     * @throws SQLException 
     */
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
    
    /**
     * Creates the Datebase
     * @throws SQLException 
     */
    private void  createDB() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "postgres");
        Statement st = con.createStatement();
        
        st.executeUpdate("CREATE DATABASE pokemon_battle_simulator");
        con.close();
        System.out.println("done");
    }
    
    /**
     * Deletes the full database structure
     * @throws SQLException 
     */
    public void deleteAll() throws SQLException
    {
        con.close();
        con = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "postgres");
        Statement st = con.createStatement();
        
        st.executeUpdate("DROP DATABASE pokemon_battle_simulator");
        con.close();
    }
    
    /**
     * Creates all needed tables
     * @throws SQLException 
     */
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
        
        
        st.executeUpdate("ALTER TABLE pokemontype ADD CONSTRAINT fk_pokemontype_pokemon"
                    + " FOREIGN KEY (PID) REFERENCES pokemon (PID);");
        st.executeUpdate("ALTER TABLE pokemontype ADD CONSTRAINT fk_pokemontype_type"
                    + " FOREIGN KEY (Bez) REFERENCES type (Bez);");
        
        st.executeUpdate("CREATE TABLE pokemonability"
                + " ("
                + " PID INTEGER,"
                + " AID INTEGER,"
                + " PRIMARY KEY(PID, AID));");
        
        st.executeUpdate("ALTER TABLE pokemonability ADD CONSTRAINT fk_pokemonability_pokemon"
                    + " FOREIGN KEY (PID) REFERENCES pokemon (PID);");
        
        st.executeUpdate("ALTER TABLE pokemonability ADD CONSTRAINT fk_pokemonability_ability"
                    + " FOREIGN KEY (AID) REFERENCES ability (AID);");
        
        st.executeUpdate("CREATE TABLE pokemonmove"
                + " ("
                + " PID INTEGER,"
                + " MID INTEGER,"
                + " PRIMARY KEY(PID, MID));");
        
        st.executeUpdate("ALTER TABLE pokemonmove ADD CONSTRAINT fk_pokemonmove_pokemon"
                    + " FOREIGN KEY (PID) REFERENCES pokemon (PID);");
        
        st.executeUpdate("ALTER TABLE pokemonmove ADD CONSTRAINT fk_pokemonmove_move"
                    + " FOREIGN KEY (MID) REFERENCES move (MID);");
        
    }
    
    /**
     * Fills the Type table
     * @throws SQLException 
     */
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
        st.execute("INSERT INTO type VALUES('none');");
        System.out.println("filled types");
    }
    
    /**
     * Fills the Pokemon table
     * @throws SQLException 
     */
    private void fillPokemon() throws SQLException
    {
        
        Statement st = con.createStatement();
        st.execute("INSERT INTO pokemon VALUES(1, 'Bulbasaur', 45, 49, 49, 65, 65, 45);");
        st.execute("INSERT INTO pokemon VALUES(2, 'Ivysaur', 60, 62, 63, 80, 80, 60);");
        st.execute("INSERT INTO pokemon VALUES(3, 'Venusaur', 80, 82, 83, 100, 100, 80);");
        st.execute("INSERT INTO pokemon VALUES(4, 'Charmander', 39, 52, 43, 60, 50, 65);");
        st.execute("INSERT INTO pokemon VALUES(5, 'Charmeleon', 58, 64, 58, 80, 65, 80);");
        st.execute("INSERT INTO pokemon VALUES(6, 'Charizard', 78, 84, 78, 109, 85, 100);");
        st.execute("INSERT INTO pokemon VALUES(7, 'Squirtle', 44, 48, 65, 50, 64, 43);");
        st.execute("INSERT INTO pokemon VALUES(8, 'Wartortle', 59, 63, 80, 65, 80, 58);");
        st.execute("INSERT INTO pokemon VALUES(9, 'Blastoise', 79, 83, 100, 85, 105, 78);");
        System.out.println("filled pokemon");
    }
    
    /**
     * Fills the Ability Table
     * @throws SQLException 
     */
    private void fillAbility() throws SQLException
    {
        Statement st = con.createStatement();
        st.execute("INSERT INTO ability VALUES(0, 'COMMING_SOON');");
        System.out.println("filled ability");
    }
    
    /**
     * fills the move Table
     * @throws SQLException 
     */
    private void fillMove() throws SQLException
    {
        Statement st = con.createStatement();
        st.execute("INSERT INTO move VALUES(1, 'Tackle','normal','physic',40,100);");
        st.execute("INSERT INTO move VALUES(2, 'Vine Whip','grass','physic',45,100);");
        st.execute("INSERT INTO move VALUES(3, 'Take Down','normal','physic',90,100);");
        st.execute("INSERT INTO move VALUES(4, 'Razor Leaf','grass','physic',55,100);");
        st.execute("INSERT INTO move VALUES(5, 'Petal Blizzard','grass','physic',90,100);");
        st.execute("INSERT INTO move VALUES(6, 'Ember','fire','spez',40,100);");
        st.execute("INSERT INTO move VALUES(7, 'Dragon Rage','dragon','spez',45,100);");
        st.execute("INSERT INTO move VALUES(8, 'Fire Fang','fire','physic',65,100);");
        st.execute("INSERT INTO move VALUES(9, 'Flame Burst','fire','spez',70,100);");
        st.execute("INSERT INTO move VALUES(10, 'Slash','normal','physic',70,100);");
        st.execute("INSERT INTO move VALUES(11, 'Flamethrower','fire','spez',90,100);");
        st.execute("INSERT INTO move VALUES(12, 'Water Gun','water','spez',40,100);");
        st.execute("INSERT INTO move VALUES(13, 'Bubble','water','spez',40,100);");
        st.execute("INSERT INTO move VALUES(14, 'Bite','dark','physic',60,100);");
        st.execute("INSERT INTO move VALUES(15, 'Water Pulse','water','spez',60,100);");
        st.execute("INSERT INTO move VALUES(16, 'Aqua Tail','water','physic',90,100);");
        st.execute("INSERT INTO move VALUES(17, 'Skull Bash','normal','physic',130,100);");
        System.out.println("moves filled");
    }
    
    /**
     * Fills the PokeType Helper-Table (Pokemon and Type)
     * @throws SQLException 
     */
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
        st.execute("INSERT INTO pokemontype VALUES(4,'fire');");
        st.execute("INSERT INTO pokemontype VALUES(4,'none');");
        st.execute("INSERT INTO pokemontype VALUES(5,'fire');");
        st.execute("INSERT INTO pokemontype VALUES(5,'none');");
        st.execute("INSERT INTO pokemontype VALUES(6,'fire');");
        st.execute("INSERT INTO pokemontype VALUES(6,'flying');");
        st.execute("INSERT INTO pokemontype VALUES(7,'water');");
        st.execute("INSERT INTO pokemontype VALUES(7,'none');");
        st.execute("INSERT INTO pokemontype VALUES(8,'water');");
        st.execute("INSERT INTO pokemontype VALUES(8,'none');");
        st.execute("INSERT INTO pokemontype VALUES(9,'water');");
        st.execute("INSERT INTO pokemontype VALUES(9,'none');");
    }
    
    /**
     * Fills the PokeMove Helper-Table (Pokemon and Move)
     * @throws SQLException 
     */
    private void fillPokeMoves() throws SQLException
    {
        Statement st = con.createStatement();
        //pid, mid
        st.execute("INSERT INTO pokemonmove VALUES(1, 1);");
        st.execute("INSERT INTO pokemonmove VALUES(2, 1);");
        st.execute("INSERT INTO pokemonmove VALUES(3, 1);");
        st.execute("INSERT INTO pokemonmove VALUES(1, 2);");
        st.execute("INSERT INTO pokemonmove VALUES(2, 2);");
        st.execute("INSERT INTO pokemonmove VALUES(3, 2);");
        st.execute("INSERT INTO pokemonmove VALUES(1, 3);");
        st.execute("INSERT INTO pokemonmove VALUES(2, 3);");
        st.execute("INSERT INTO pokemonmove VALUES(3, 3);");
        st.execute("INSERT INTO pokemonmove VALUES(1, 4);");
        st.execute("INSERT INTO pokemonmove VALUES(2, 4);");
        st.execute("INSERT INTO pokemonmove VALUES(3, 4);");
        st.execute("INSERT INTO pokemonmove VALUES(1, 5);");
        st.execute("INSERT INTO pokemonmove VALUES(2, 5);");
        st.execute("INSERT INTO pokemonmove VALUES(3, 5);");
        st.execute("INSERT INTO pokemonmove VALUES(4, 6);");
        st.execute("INSERT INTO pokemonmove VALUES(4, 7);");
        st.execute("INSERT INTO pokemonmove VALUES(4, 8);");
        st.execute("INSERT INTO pokemonmove VALUES(4, 9);");
        st.execute("INSERT INTO pokemonmove VALUES(4, 10);");
        st.execute("INSERT INTO pokemonmove VALUES(4, 11);");
        st.execute("INSERT INTO pokemonmove VALUES(5, 6);");
        st.execute("INSERT INTO pokemonmove VALUES(5, 7);");
        st.execute("INSERT INTO pokemonmove VALUES(5, 8);");
        st.execute("INSERT INTO pokemonmove VALUES(5, 9);");
        st.execute("INSERT INTO pokemonmove VALUES(5, 10);");
        st.execute("INSERT INTO pokemonmove VALUES(5, 11);");
        st.execute("INSERT INTO pokemonmove VALUES(6, 6);");
        st.execute("INSERT INTO pokemonmove VALUES(6, 7);");
        st.execute("INSERT INTO pokemonmove VALUES(6, 8);");
        st.execute("INSERT INTO pokemonmove VALUES(6, 9);");
        st.execute("INSERT INTO pokemonmove VALUES(6, 10);");
        st.execute("INSERT INTO pokemonmove VALUES(6, 11);");
        st.execute("INSERT INTO pokemonmove VALUES(7, 12);");
        st.execute("INSERT INTO pokemonmove VALUES(7, 13);");
        st.execute("INSERT INTO pokemonmove VALUES(7, 14);");
        st.execute("INSERT INTO pokemonmove VALUES(7, 15);");
        st.execute("INSERT INTO pokemonmove VALUES(7, 16);");
        st.execute("INSERT INTO pokemonmove VALUES(7, 17);");
        st.execute("INSERT INTO pokemonmove VALUES(8, 12);");
        st.execute("INSERT INTO pokemonmove VALUES(8, 13);");
        st.execute("INSERT INTO pokemonmove VALUES(8, 14);");
        st.execute("INSERT INTO pokemonmove VALUES(8, 15);");
        st.execute("INSERT INTO pokemonmove VALUES(8, 16);");
        st.execute("INSERT INTO pokemonmove VALUES(8, 17);");
        st.execute("INSERT INTO pokemonmove VALUES(9, 12);");
        st.execute("INSERT INTO pokemonmove VALUES(9, 13);");
        st.execute("INSERT INTO pokemonmove VALUES(9, 14);");
        st.execute("INSERT INTO pokemonmove VALUES(9, 15);");
        st.execute("INSERT INTO pokemonmove VALUES(9, 16);");
        st.execute("INSERT INTO pokemonmove VALUES(9, 17);");
    }
    
    /**
     * Fills the PokeAbilties Helper-Table (Pokemon and Ability)
     * @throws SQLException 
     */
    private void fillPokeAbilities() throws SQLException
    {
        Statement st = con.createStatement();
        //pid, aid
        st.execute("INSERT INTO pokemonability VALUES(1,0);");
        st.execute("INSERT INTO pokemonability VALUES(2,0);");
        st.execute("INSERT INTO pokemonability VALUES(3,0);");
        st.execute("INSERT INTO pokemonability VALUES(4,0);");
        st.execute("INSERT INTO pokemonability VALUES(5,0);");
        st.execute("INSERT INTO pokemonability VALUES(6,0);");
        st.execute("INSERT INTO pokemonability VALUES(7,0);");
        st.execute("INSERT INTO pokemonability VALUES(8,0);");
        st.execute("INSERT INTO pokemonability VALUES(9,0);");
    }
    
    /**
     * Returns the Database instance
     * @return
     * @throws SQLException 
     */
    public static DB getInstance() throws SQLException
    {
        if(instance == null)
            instance = new DB();
        return instance;
    }
    
    /**
     * Loads all pokemon from the database in a arrylist
     * @throws SQLException 
     */
    private void loadPokemon() throws SQLException
    {        
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
    
    /**
     * Returns all loaded pokemon from the arraylist as arraylist (ArrayList<data.Pokemon>)
     * @return 
     */
    public ArrayList<data.Pokemon> getPokemonFromDB()
    {
        return pkm;
    }
    
    /**
     * Returns the Movelist from a pokemon, which is saved in the databank
     * @param pkm
     * @return
     * @throws SQLException 
     */
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
    
    
    /**
     * Returns all possible abilites of given pokemon which is saved in the db
     * @param pkm
     * @return
     * @throws SQLException 
     */
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
