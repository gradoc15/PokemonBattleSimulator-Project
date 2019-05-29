/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import data.Pokemon;
import data.PokemonExtended;

/**
 *
 * @author User
 */
public class battleBl
{
    private data.PokemonExtended ownTeam[];
    private data.PokemonExtended enemyTeam[];
    private boolean myTurn = true;
    private data.PokemonExtended actualPkmOwn;
    private data.PokemonExtended actualPkmEnemy;

    public battleBl(data.Pokemon ownTeam[], data.Pokemon enemyTeam[])
    {
        this.ownTeam = new data.PokemonExtended[ownTeam.length];
        this.enemyTeam = new data.PokemonExtended[enemyTeam.length];
        
        for(int i = 0; i < ownTeam.length; i++)
        {
            System.out.println(ownTeam.length);
            this.ownTeam[i] = new data.PokemonExtended(ownTeam[i]);
        }
        
        for(int i = 0; i < this.enemyTeam.length; i++)
        {
            this.enemyTeam[i] = new data.PokemonExtended(enemyTeam[i]);
        }
        
        
        
        
        System.out.println("++++");
        
        actualPkmOwn = this.ownTeam[0];
        actualPkmEnemy = this.enemyTeam[0];
        
        
        System.out.println("Own team. "+ownTeam.length);
        System.out.println("Enemy team: "+enemyTeam.length);
    }

    public void changeActPokemon(boolean myTurn, int slot)
    {
        
        if(myTurn)
        {
           if(ownTeam.length <= slot && slot >= 0)
           {
               System.out.println("Change");
               if(ownTeam[slot].isBattleRdy())
                   actualPkmOwn = ownTeam[slot];
           }
        }
        else
        {
            if(enemyTeam.length <= slot && slot >= 0)
                if(enemyTeam[slot].isBattleRdy())
                    actualPkmEnemy = enemyTeam[slot];
        }
    }
    
    public void makeMove(int slot) throws Exception
    {
        if(myTurn)
        {
            if(actualPkmOwn.getMovePP()[slot] >= 0)
            {
                actualPkmOwn.setMovePPAt(slot, actualPkmOwn.getMovePP()[slot]-1);
                actualPkmEnemy.minusHP(actualPkmOwn.calcDmg(slot, actualPkmEnemy));
                
                System.out.println("new % enemy: "+actualPkmOwn.calcDmg(slot, actualPkmEnemy));
            }
            else
                throw new Exception("Not Enought pp");
        }
    }

    public data.PokemonExtended getActPokemon()
    {
        return (myTurn ?  actualPkmOwn : actualPkmEnemy);
    }
    
    public int getHPPercent()
    {
        if(myTurn)
            return (int) (100.0/actualPkmOwn.getRealStats().getHp()*actualPkmOwn.getCurrentHP());
        else
            return (int) (100.0/actualPkmEnemy.getRealStats().getHp()*actualPkmEnemy.getCurrentHP());
    }
    
    
    public void setTurn(boolean myTurn)
    {
        this.myTurn = myTurn;
    }

    public PokemonExtended[] getOwnTeam()
    {
        return ownTeam;
    }

    public PokemonExtended[] getEnemyTeam()
    {
        return enemyTeam;
    }

    public boolean isMyTurn()
    {
        return myTurn;
    }

    public PokemonExtended getActualPkmOwn()
    {
        return actualPkmOwn;
    }

    public PokemonExtended getActualPkmEnemy()
    {
        return actualPkmEnemy;
    }
    
    
    
    

    
    
}
