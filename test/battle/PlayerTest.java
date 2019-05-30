/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import data.Ability;
import data.Nature;
import data.Pokemon;
import data.PokemonExtended;
import data.Values;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author User
 */
@RunWith(value = Parameterized.class)
public class PlayerTest {
    
    
    @Parameterized.Parameter(value = 0)
        public boolean actTurnPlayer1;
    
    @Parameterized.Parameter(value = 1)
        public int moveSlot;
    @Parameterized.Parameter(value = 2)
        public String typeAtk;
    @Parameterized.Parameter(value = 3)
        public String typeDef;
    @Parameterized.Parameter(value = 4)
        public double typeValue;
    @Parameterized.Parameter(value = 5)
        public int changePokemonSlot;
    
    
    public data.PokemonExtended[] getTeam()
    {
        data.Pokemon teamBl[] = {
            new Pokemon(-1, "Test1", new data.Values(10, 10, 10, 10, 10, 10), "none", "none", new Ability("none")),
            new Pokemon(-1, "Test2", new data.Values(10, 10, 10, 10, 10, 10), "none", "none", new Ability("none")),
            new Pokemon(-1, "Test3", new data.Values(10, 10, 10, 10, 10, 10), "none", "none", new Ability("none")),
            new Pokemon(-1, "Test4", new data.Values(10, 10, 10, 10, 10, 10), "none", "none", new Ability("none")),};
        
        for(int i = 0; i < teamBl.length; i++)
        {
            if(teamBl[i]  != null)
            {
                teamBl[i].setIv(new Values(5, 5, 5, 5, 5, 5));
                teamBl[i].setEv(new Values(5, 5, 5, 5, 5, 5));
                teamBl[i].setNature(Nature.NAIVE);
            }
        }
        
        data.PokemonExtended team[] = new PokemonExtended[teamBl.length];
        
        for(int i = 0; i < team.length; i++)
        {
            team[i] = new PokemonExtended(teamBl[i]);
        }
        
        return team;
    }
    
    @Parameterized.Parameters(name = "")
    public static Iterable<Object[]> data1()
    {
        return Arrays.asList(new Object[][]
        {
            {true,0,"fairy","dark",2,3},
            {true,2,"ghost","dark",1,1},
            {true,3,"fairy","normal",1,2},
            {true,1,"steel","fire",0.5,0},
            {true,2,"fire","steel",2,3}

                
        });
                 
    } 
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of useMove method, of class Player.
     * Tests if the pp of the used slot is lowered by one
     */
    @Test
    public void testUseMove() {
        System.out.println("useMove");
        int moveSlot = this.moveSlot;
        Player instance = new Player(getTeam());
        int oldPP = instance.getActivePokemon().getMovePPOf(moveSlot);
        instance.useMove(moveSlot);
        
        assertEquals(oldPP-1, instance.getActivePokemon().getMovePPOf(moveSlot));

    }

    /**
     * Test of calculteTypeInteraction method, of class Player.
     */
    @Test
    public void testCalculteTypeInteraction() {
        System.out.println("calculteTypeInteraction");
        String typeAtk = this.typeAtk;
        String typeDef = this.typeDef;
        Player instance = new Player(getTeam()) ;
        double expResult = typeValue;
        double result = instance.calculteTypeInteraction(typeAtk, typeDef);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of changePokemon method, of class Player.
     */
    @Test
    public void testChangePokemon() throws Exception {
        System.out.println("changePokemon");
        int teamSlot = changePokemonSlot;
        Player instance = new Player(getTeam());
        instance.changePokemon(teamSlot);
        
        assertEquals(instance.getActivePokemon().getStatSum(), getTeam()[changePokemonSlot].getStatSum());
    }


    /**
     * Test of countRemainingPokemon method, of class Player.
     * Tests if the remaing pokemon are counted right
     */
    @Test
    public void testCountRemainingPokemon() {
        System.out.println("countRemainingPokemon");
        Player instance = new Player(getTeam());
        int expResult = 0;
        
        for(int i = 0; i < getTeam().length; i++)
        {
            if(getTeam()[i].isAlive())
                expResult++;
        }
        int result = instance.countRemainingPokemon();
        assertEquals(expResult, result);
    }

    /**
     * Test of haveRemainingPokemon method, of class Player.
     * Tests if there are any remaining pokemon in the team
     */
    @Test
    public void testHaveRemainingPokemon() {
        System.out.println("haveRemainingPokemon");
        Player instance = new Player(getTeam());
        int expResult = 0;
        
        for(int i = 0; i < getTeam().length; i++)
        {
            if(getTeam()[i].isAlive())
                expResult++;
        }
        
        boolean result = instance.haveRemainingPokemon();
        
        assertEquals((expResult > 0 ? true: false), result);
    }

    
}
