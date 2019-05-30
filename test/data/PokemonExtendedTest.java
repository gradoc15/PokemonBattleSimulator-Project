/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
public class PokemonExtendedTest {
    
    @Parameterized.Parameter(value = 0)
        public boolean actTurnPlayer1;
    @Parameterized.Parameter(value = 1)
        public int amountHPToSubstract;
    @Parameterized.Parameter(value = 2)
        public int moveSlot;
    @Parameterized.Parameter(value = 3)
        public int subTestAlive;
    
    
    
    public data.Pokemon getPokemon()
    {
        data.Pokemon p = new data.Pokemon(-1, "test", new Values(5, 5, 5, 5, 5, 5), "normal", "none", new Ability("none"));
        p.setIv(new Values(5, 5, 5, 5, 5, 5));
        p.setEv(new Values(5, 5, 5, 5, 5, 5));
        p.setNature(Nature.NAIVE);
        
        return p;
    }
    
    
    @Parameterized.Parameters(name = "")
    public static Iterable<Object[]> data1()
    {
        return Arrays.asList(new Object[][]
        {
            {true,15,2,105},
            {true,75,1,700},
            {true,0,3,0},
            {true,360,0,1500},
            {true,56,2,42}

                
        });
                 
    }
    public PokemonExtendedTest() {
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
     * Test of subHP method, of class PokemonExtended.
     * Tests if the hp are subtracted correctly
     */
    @Test
    public void testSubHP() {
        System.out.println("subHP");
        int amount = amountHPToSubstract;
        PokemonExtended instance = new data.PokemonExtended(getPokemon());
        int expResult = instance.getCurrentHP()-amountHPToSubstract;
        expResult = (expResult < 0 ? 0 : expResult);
        instance.subHP(amount);
        assertEquals(expResult, instance.getCurrentHP());
    }

    /**
     * Test of getMoveAt method, of class PokemonExtended.
     * If the correct move is returned
     */
    @Test
    public void testGetMoveAt() {
        System.out.println("getMoveAt");
        int slot = moveSlot;
        PokemonExtended instance = new PokemonExtended(getPokemon());
        Move expResult = getPokemon().getMove()[moveSlot];
        Move result = instance.getMoveAt(slot);
        assertEquals(expResult, result);
    }

    /**
     * Test of useMove method, of class PokemonExtended.
     * Tests if the correct movePP is subtracted by one
     */
    @Test
    public void testUseMove() {
        System.out.println("useMove");
        int slot = moveSlot;
        PokemonExtended instance = new PokemonExtended(getPokemon());
        int oldPP = instance.getMovePPOf(slot);
        instance.useMove(slot);
        assertEquals(oldPP-1, instance.getMovePPOf(slot));
    }

    /**
     * Test of isAlive method, of class PokemonExtended.
     * if the current hp of the pokemon is more than 1
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        PokemonExtended instance = new PokemonExtended(getPokemon());
        boolean expResult = (instance.getCurrentHP()-subTestAlive > 0 ? true: false);
        instance.subHP(subTestAlive);
        boolean result = instance.isAlive();
        assertEquals(expResult, result);

    }

}
