/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import java.util.Random;

/**
 *
 * @author User
 */
public class Enemy 
{
    private boolean pokemon[];
    
    public Enemy(int amountPkm)
    {
        pokemon = new boolean[amountPkm];
        
        for(int i = 0; i < pokemon.length; i++)
        {
            pokemon[i] = true;
        }
    }
    
    
    public int getAmount()
    {
        return pokemon.length;
    }
    
    public boolean isDefeated()
    {
        int anz = 0;
        
        for(int i = 0; i < pokemon.length; i++)
        {
            if(!pokemon[i])
                anz++;
        }
        
        System.out.println("Anzzz: "+anz);
        System.out.println(pokemon.length);
        return (anz==pokemon.length ? true : false);
    }
    
    public void addDefeated()
    {
        for(int i = 0; i < pokemon.length; i++)
        {
            if(pokemon[i])
            {
                pokemon[i] = false;
                break;
            }
        }
    }
    
    public int makeMove()
    {
        Random rand = new Random();
        return rand.nextInt(4);
    }
    
    public int getNextSlot()
    {
        for(int i = 0; i < pokemon.length; i++)
            if(pokemon[i])
                return i;
       
        return 0;
    }
}
