/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import data.PokemonExtended;
import java.util.Random;

/**
 *
 * @author User
 */
public class Player 
{
    private boolean defeated;
    private data.PokemonExtended team[];
    private data.PokemonExtended actPkm;

    public Player(PokemonExtended[] team) 
    {
        this.team = team;
        actPkm = team[0];
    }
    
    /**
     * This method calculates to damage which is dealt to the enemy pokemon
     * @param moveSlot
     * @param enemy
     * @return 
     */
    public int calculateDmg(int moveSlot, data.PokemonExtended enemy)
    {
        Random rand = new Random();
        
        double lvl = actPkm.getLvl()*(2.0/5);
        int basicDmg = actPkm.getMove()[moveSlot].getPower();
        double statFactor =  (actPkm.getMove()[moveSlot].getCat().equals("physic") ? actPkm.getRealStats().getAtk()/(enemy.getRealStats().getDef()*50.0) : actPkm.getRealStats().getSpAtk()/(enemy.getRealStats().getSpDef()*50.0));
        double stabMultiplicator = (actPkm.getType1().equals(actPkm.getMove()[moveSlot].getType()) || actPkm.getType2().equals(actPkm.getMove()[moveSlot].getType())? 1.5 : 1);
        double randomValue = rand.nextInt(16)/100.0;
        double typeMultiplicator = calculteTypeInteraction(actPkm.getMove()[moveSlot].getType(), enemy.getType1()) * (!enemy.getType2().equals("none") ? calculteTypeInteraction(actPkm.getMove()[moveSlot].getType(), enemy.getType2()) : 1);
        
        return (int)((lvl*basicDmg*statFactor)*randomValue*stabMultiplicator*typeMultiplicator);
    }
    
    /**
     * This method substracts one fromt the current pp of a move
     * @param moveSlot 
     */
    public void useMove(int moveSlot)
    {
        actPkm.useMove(moveSlot);
    }
    
    /**
     * This method calculates the type interaction from a attacking type and a defensive type, and return the calculated value
     * @param typeAtk
     * @param typeDef
     * @return 
     */
    public double calculteTypeInteraction(String typeAtk, String typeDef)
    {   
        switch(typeAtk)
        {
            case "normal":
                switch(typeDef)
                {
                    case "rock":
                    case "steel": return 0.5;
                    case "ghost": return 0;
                }break;
            case "fire":
                switch(typeDef)
                {
                    case "rock":
                    case "fire":
                    case "water":
                    case "dragon": return 0.5;
                    case "bug":
                    case "grass":
                    case "ice": return 2;
                }break;
            case "water":
                switch(typeDef)
                {
                    case "water":
                    case "grass":
                    case "dragon": return 0.5;
                    case "ground":
                    case "rock":
                    case "fire": return 2;
                }break;
            case "grass":
                switch(typeDef)
                {
                    case "flying":
                    case "bug":
                    case "poison":
                    case "steel":
                    case "fire":
                    case "grass":
                    case "dragon": return 0.5;
                    case "rock":
                    case "ground":
                    case "water": return 2;
                }break;
            case "electric":
                switch(typeDef)
                {
                    case "ground": return 0;
                    case "grass":
                    case "electric":
                    case "dragon":  return 0.5;
                    case "flying":
                    case "water": return 2;
                }break;
            case "ice":
                switch(typeDef)
                {
                    case "steel":
                    case "fire":
                    case "water":
                    case "ice": return 0.5;
                    case "flying":
                    case "ground":
                    case "grass":
                    case "dragon": return 2;
                }break;
            case "fighting":
                switch(typeDef)
                {
                    case "ghost": return 0;
                    case "flying":
                    case "poison":
                    case "bug":
                    case "psychic":
                    case "fairy": return 0.5;
                    case "normal":
                    case "rock":
                    case "steel":
                    case "ice":
                    case "dark": return 2;
                }break;
            case "poison":
                switch(typeDef)
                {
                    case "steel": return 0;
                    case "poison":
                    case "ground":
                    case "rock":
                    case "ghost": return 0.5;
                    case "grass":
                    case "fairy": return 2;
                }break;
            case "ground":
                switch(typeDef)
                {
                    case "flying": return 0;
                    case "bug":
                    case "grass": return 0.5;
                    case "electric":
                    case "rock":
                    case "fire":
                    case "steel":
                    case "ice": return 2;
                }break;
            case "flying":
                switch(typeDef)
                {
                    case "rock":
                    case "steel":
                    case "electric": return 0.5;
                    case "bug":
                    case "grass":
                    case "fighting": return 2;
                }break;
            case "psychic":
                switch(typeDef)
                {
                    case "dark": return 0;
                    case "steel":
                    case "psychic": return 0.5;
                    case "fighting":
                    case "poison": return 2;
                }break;
            case "bug":
                switch(typeDef)
                {
                    case "fighting":
                    case "flying":
                    case "poison":
                    case "ghost":
                    case "steel":
                    case "fire":
                    case "fairy": return 0.5;
                    case "grass":
                    case "psychic":
                    case "dark": return 2;
                }break;
            case "rock":
                switch(typeDef)
                {
                    case "fighting":
                    case "ground":
                    case "steel": return 0.5;
                    case "flying":
                    case "bug":
                    case "fire":
                    case "ice": return 2;
                }break;
            case "ghost":
                switch(typeDef)
                {
                    case "normal": return 0;
                    case "dark": return 0.5;
                    case "psychic":
                    case "ghost": return 2;
                }break;
            case "dragon":
                switch(typeDef)
                {
                    case "fairy": return 0;
                    case "steel": return 0.5;
                    case "dragon": return 2;
                }break;
            case "steel":
                switch(typeDef)
                {
                    case "steel":
                    case "fire":
                    case "water":
                    case "electric": return 0.5;
                    case "ice":
                    case "fairy":
                    case "rock":
                }break;
            case "fairy":
                switch(typeDef)
                {
                    case "poison":
                    case "steel":
                    case "fire": return 0.5;
                    case "fighting":
                    case "dragon": return 2;
                }break;
        }
        
        return 1;
    }
    
    /**
     * This method changes the current activ pokemon of this player
     * @param teamSlot 
     */
    public void changePokemon(int teamSlot)
    {
        actPkm = team[teamSlot];
    }
    
    /**
     * Returns the Pokemon which is on the given slot
     * @param slot
     * @return 
     */
    public data.PokemonExtended getPokemonAtSlot(int slot)
    {
        return team[slot]; 
    }
    public int countRemainingPokemon()
    {
        int sum = 0;
        for(int i = 0; i < team.length; i++)
        {
            if(team[i].isAlive())
                sum++;
        }
        
        return sum;
    }
}
