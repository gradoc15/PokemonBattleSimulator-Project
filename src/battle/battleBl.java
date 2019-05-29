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
    private Enemy enemy;
    private boolean defeated = false;
    private boolean gameover = false;
    private boolean forceSwitch = false;

    public battleBl(data.Pokemon ownTeam[], data.Pokemon enemyTeam[])
    {
        this.ownTeam = new data.PokemonExtended[ownTeam.length];
        this.enemyTeam = new data.PokemonExtended[enemyTeam.length];
        enemy = new Enemy(this.enemyTeam.length);
        
        for(int i = 0; i < ownTeam.length; i++)
        {
            System.out.println(ownTeam.length);
            this.ownTeam[i] = new data.PokemonExtended(ownTeam[i]);
        }
        
        for(int i = 0; i < this.enemyTeam.length; i++)
        {
            this.enemyTeam[i] = new data.PokemonExtended(enemyTeam[i]);
        }
        

        actualPkmOwn = this.ownTeam[0];
        actualPkmEnemy = this.enemyTeam[0];
        
        
    }
        

    public void changeActPokemon(boolean myTurn, int slot) throws Exception
    {
        
        if(myTurn)
        {
           if(ownTeam.length > slot && slot >= 0)
           {
               
               if(ownTeam[slot].isBattleRdy())
                   actualPkmOwn = ownTeam[slot];
               else
                   throw new Exception("The selected Pokemon is defeated, please select another one");
           }
           else
               throw new Exception("Invalid Slot");
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
        if(!gameover)
        {
            if(myTurn)
            {
                if(actualPkmOwn.getMovePP()[slot] > 0)
                {
                    actualPkmOwn.setMovePPAt(slot, actualPkmOwn.getMovePP()[slot]-1);
                    actualPkmEnemy.minusHP(actualPkmOwn.calcDmg(slot, actualPkmEnemy));

                    System.out.println("new % enemy: "+actualPkmOwn.calcDmg(slot, actualPkmEnemy));
                }
                else
                {
                    boolean validMoveAviable = false;
                    for(int i = 0; i < actualPkmOwn.getMovePP().length; i++)
                    {
                        if(actualPkmOwn.getMovePP()[i] > 1)
                        {
                            validMoveAviable = true;
                            break;
                        }
                    }
                    if(validMoveAviable)
                        throw new Exception("Not Enought pp");
                    else
                        actualPkmEnemy.minusHP(actualPkmOwn.calcStruggle(actualPkmEnemy));
                }
            }
            else
            {
                System.out.println("MAKING MOVE");
                if(actualPkmEnemy.getMovePP()[slot] > 0)
                {
                    actualPkmEnemy.setMovePPAt(slot, actualPkmEnemy.getMovePP()[slot]-1);
                    actualPkmOwn.minusHP(actualPkmEnemy.calcDmg(slot, actualPkmOwn));


                }
                else
                {

                    boolean validMoveAviable = false;
                    for(int i = 0; i < actualPkmEnemy.getMovePP().length; i++)
                    {
                        if(actualPkmEnemy.getMovePP()[i] > 1)
                        {
                            validMoveAviable = true;
                            break;
                        }
                    }
                    if(validMoveAviable)
                        makeMove(enemy.makeMove());
                    else
                        actualPkmOwn.minusHP(actualPkmEnemy.calcStruggle(actualPkmOwn));
                }

                nextTurn();
            }

        }
    }
    
    public void changeEnemyPkm()
    {
        gameover = enemy.isDefeated();
        System.out.println(gameover);
        if(!gameover)
        {
            actualPkmEnemy=enemyTeam[enemy.getNextSlot()];
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
    
    public void nextTurn() throws Exception
    {
        myTurn = !myTurn;
        
        if(!myTurn)
           makeMove(enemy.makeMove());
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

    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public boolean isForceSwitch() {
        return forceSwitch;
    }

    public void setForceSwitch(boolean forceSwitch) {
        this.forceSwitch = forceSwitch;
    }

    public boolean isGameover() {
        return gameover;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }
    
    
    
    
    

    
    
}
