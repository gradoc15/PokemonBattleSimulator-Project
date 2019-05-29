/*
 * To change this l"ice"nse header, choose L"ice"nse Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class PokemonExtended extends Pokemon
{
    private Values realStats;
    
    private int currentHP;
    private boolean alive = true;
    
    private int movePP[] = new int[4];

    
    public PokemonExtended(int id, String name, Values basicValues, String type1, String type2, Ability ability)
    {
        super(id, name, basicValues, type1, type2, ability);
        
        
    }
    
    public PokemonExtended(data.Pokemon pkm)
    {
        super(pkm.getId(), pkm.getName(), pkm.getBasicValues(), pkm.getType1(), pkm.getType2(), pkm.getAbility());
        
        super.setNature(pkm.getNature());
        super.setMove(pkm.getMove());
        
        init();
    }
    
    /**
     * Calculates and sets the realstats, also sets the maximum pp of the moves and sets the current hp to the maximum
     */
    public void init()
    {
        //Calculates the realstats
        realStats = new Values(((int)((((basicValues.getHp()*2.0+iv.getHp()+(ev.getHp()/4))*lvl)/100.0)+lvl+10)),
                (int) ((((2.0*basicValues.getAtk()+iv.getAtk()+ev.getAtk()/4)*lvl/100)+lvl+10)*(nature.getPositiv().equals(data.Stat.ATK) ? 1.1 : 1)*(nature.getNegativ().equals(data.Stat.ATK) ? 0.9 : 1)),
                (int) ((((2.0*basicValues.getDef()+iv.getDef()+ev.getDef()/4)*lvl/100)+lvl+10)*(nature.getPositiv().equals(data.Stat.DEF) ? 1.1 : 1)*(nature.getNegativ().equals(data.Stat.DEF) ? 0.9 : 1)),
                (int) ((((2.0*basicValues.getSpAtk()+iv.getSpAtk()+ev.getSpAtk()/4)*lvl/100)+lvl+10)*(nature.getPositiv().equals(data.Stat.SPATK) ? 1.1 : 1)*(nature.getNegativ().equals(data.Stat.SPATK) ? 0.9 : 1)),
                (int) ((((2.0*basicValues.getSpDef()+iv.getSpDef()+ev.getSpDef()/4)*lvl/100)+lvl+10)*(nature.getPositiv().equals(data.Stat.SPDEF) ? 1.1 : 1)*(nature.getNegativ().equals(data.Stat.SPDEF) ? 0.9 : 1)),
                (int) ((((2.0*basicValues.getIni()+iv.getIni()+ev.getIni()/4)*lvl/100)+lvl+10)*(nature.getPositiv().equals(data.Stat.INIT) ? 1.1 : 1)*(nature.getNegativ().equals(data.Stat.INIT) ? 0.9 : 1)));
        
        //Init movePP
        for(int i = 0; i < movePP.length; i++)
        {
            movePP[i] = 15;
        }
        
        //Sets current HP to max HP
        currentHP = realStats.getHp();
    }
    
    /**
     * Substracts an amount of HP of the current HP and checks if the pokemon is still alive or not
     * @param amount 
     */
    public void subHP(int amount)
    {
        currentHP -= amount;
        if(currentHP < 0)
            currentHP = 0;
        if(currentHP == 0)
            alive = false;
    }
    
    /**
     * Return the move which is on the given slot
     * @param slot
     * @return 
     */
    public data.Move getMoveAt(int slot)
    {
        return move[slot];
    }
    
    public int getMovePPOf(int slot)
    {
        return movePP[slot];
    }
    
    /**
     * Substracts the move pp by 1
     * @param slot 
     */
    public void useMove(int slot)
    {
        movePP[slot] = movePP[slot]-1;
    }
    
    /**
     * Returns the realstats
     * @return 
     */
    public Values getRealStats()
    {
        return realStats;
    }

    /**
     * Returns a boolean, if true the pokemon is still alive
     * @return 
     */
    public boolean isAlive() {
        return alive;
    }
    
    /**
     * retuns movePPs of all movess
     * @return 
     */
    public int[] getMovePP()
    {
        return movePP;
    }
    
    public int getCurrentHP()
    {
        return currentHP;
    }
}
