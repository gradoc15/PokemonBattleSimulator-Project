/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import data.Ability;
import data.Nature;
import data.Pokemon;
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
public class BattleBlTest {
    
    @Parameterized.Parameter(value = 0)
        public boolean actTurnPlayer1;
    
    @Parameterized.Parameter(value = 1)
        public int changeToSlot;
    
    @Parameterized.Parameter(value = 2)
        public int moveSlot;
    
    public data.Pokemon[] getTeam()
    {
        data.Pokemon team[] = {
            new Pokemon(-1, "Test1", new data.Values(10, 10, 10, 10, 10, 10), "none", "none", new Ability("none")),
            new Pokemon(-1, "Test2", new data.Values(10, 10, 10, 10, 10, 10), "none", "none", new Ability("none")),
            new Pokemon(-1, "Test3", new data.Values(10, 10, 10, 10, 10, 10), "none", "none", new Ability("none")),
            new Pokemon(-1, "Test4", new data.Values(10, 10, 10, 10, 10, 10), "none", "none", new Ability("none")),
            null, null};
        
        for(int i = 0; i < team.length; i++)
        {
            if(team[i]  != null)
            {
                team[i].setIv(new Values(5, 5, 5, 5, 5, 5));
                team[i].setEv(new Values(5, 5, 5, 5, 5, 5));
                team[i].setNature(Nature.NAIVE);
            }
        }
        
        return team;
    }
    
    @Parameterized.Parameters(name = "")
    public static Iterable<Object[]> data1()
    {
        return Arrays.asList(new Object[][]
        {
            {true,2,2}

                
        });
                 
    }  
    
    public BattleBlTest() {
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
     * Test of nextTurn method, of class BattleBl.
     * Tests if the boolean playerTurn1 is changing after the method call nextTurn
     */
    @Test
    public void testNextTurn() {
        System.out.println("nextTurn");

        BattleBl instance = new BattleBl(getTeam());
        boolean oldTurn = instance.isTurnPlayer1();
        instance.nextTurn();
        
        assertEquals(oldTurn, !instance.isTurnPlayer1());
    }

    /**
     * Test of changePokemon method, of class BattleBl.
     * Tests if the pokemon is changed to the correct slot
     */
    @Test
    public void testChangePokemon() throws Exception {
        System.out.println("changePokemon");
        int slot = changeToSlot;
        BattleBl instance = new BattleBl(getTeam());
        instance.changePokemon(slot);
        assertEquals(new data.PokemonExtended(getTeam()[slot]).getStatSum(), instance.getPlayer1().getActivePokemon().getStatSum());
        // TODO review the generated test code and remove the default call to fail.
    } 
}
