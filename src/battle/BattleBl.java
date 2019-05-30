/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import data.Pokemon;
import data.PokemonExtended;
import java.util.Random;

/**
 *
 * @author User
 */
public class BattleBl
{
    private boolean turnPlayer1 = true;
    
    private Player player1 = null;
    private Player player2 = null;
    
    private boolean gameover = false;
    private boolean winnerPlayer1 = false;
    
    private Random rand = new Random();
    
    /**
     * Construcor, creates players and creates teams out of PokemonExtended Objects from Pokemon objects
     * @param team team of player1
     */
    public BattleBl(Pokemon[] team)
    {
        int sizeOfTeam = 0;
        for(int i = 0; i < team.length; i++)
        {
            if(team[i] != null)
                sizeOfTeam ++;
        }
        
        PokemonExtended nTeam[] = new PokemonExtended[sizeOfTeam]; 
        for(int i = 0; i < nTeam.length; i++)
        {
            nTeam[i] = new PokemonExtended(team[i]);
        }
        
        player1 = new Player(nTeam);
        
        nTeam = new PokemonExtended[(sizeOfTeam >= 3 ? 3 : 1)];
        for(int i = 0; i < nTeam.length; i++)
        {
            nTeam[i] = new PokemonExtended(team[i]);
        }
        
        player2 = new Player(nTeam);
    }
    
    /**
     * Changes to players turn to the next
     */
    public void nextTurn()
    {
        turnPlayer1 = !turnPlayer1;
    }
    
    /**
     * Changes to currenct pokemon of a player
     * @param slot of the wanted pokemon
     * @throws Exception if slot is invalid (out of bounce)
     */
    public void changePokemon(int slot) throws Exception
    {
        if(turnPlayer1)
            player1.changePokemon(slot);
        else
            player2.changePokemon(slot);
        
        nextTurn();
    }
    
    /**
     * Uses move and deals damage to the enemy, and checks move pp
     * @param moveSlot slot of the move which is choosen to attack
     * @throws Exception if the move has no pp
     */
    public void attack(int moveSlot) throws Exception
    {
        if(!gameover)
        {
            boolean blockNextTurn = false;

            if(turnPlayer1)
            {
                if(player1.getActivePokemon().getMovePPOf(moveSlot) > 0)
                {
                    player2.getActivePokemon().subHP(player1.calculateDmg(moveSlot, player2.getActivePokemon()));
                    player1.useMove(moveSlot);
                }
                else
                {
                    boolean validAttackPossible = false;
                    for(int i = 0; i < player1.getActivePokemon().getMovePP().length; i++)
                    {
                        if(player1.getActivePokemon().getMovePP()[i] > 0)
                        {
                            validAttackPossible = true;
                            break;
                        }
                    }

                    if(validAttackPossible)
                        throw new Exception("This move has no more pp");
                    else
                    {
                        player2.getActivePokemon().subHP(player1.calculateStruggle(player2.getActivePokemon()));
                        player1.getActivePokemon().subHP(player1.getActivePokemon().getRealStats().getHp()/4);
                    }
                }
            }
            else
            {
                if(player2.getActivePokemon().getMovePPOf(moveSlot) > 0)
                {
                    player1.getActivePokemon().subHP(player2.calculateDmg(moveSlot, player1.getActivePokemon()));
                    player2.useMove(moveSlot);
                }
                else
                {
                    boolean validAttackPossible = false;
                    for(int i = 0; i < player2.getActivePokemon().getMovePP().length; i++)
                    {
                        if(player2.getActivePokemon().getMovePP()[i] > 0)
                        {
                            validAttackPossible = true;
                            break;
                        }
                    }

                    if(validAttackPossible)
                    {
                        blockNextTurn = true;
                        System.out.println("asd");
                        attack(rand.nextInt(4));
                        
                    }
                    else
                    {
                        player1.getActivePokemon().subHP(player2.calculateStruggle(player1.getActivePokemon()));
                        player2.getActivePokemon().subHP(player2.getActivePokemon().getRealStats().getHp()/4);
                        
                        
                    }
                }
            }
            
            if(player1.getActivePokemon().getCurrentHP() <= 0)
                player1.forceSwitch();
            if(player2.getActivePokemon().getCurrentHP() <= 0)
                player2.forceSwitch();
            
            if(!blockNextTurn)
                nextTurn();

            checkWinner();
        }
    }

    
    /**
     * Returns the turn state
     * @return turnPlayer1
     */
    public boolean isTurnPlayer1() {
        return turnPlayer1;
    }

    /**
     * Returns player1 object
     * @return Player1 (Player object)
     */
    public Player getPlayer1() {
        return player1;
    }
    
    /**
     * Checks if there is a winner, if yes the gameover boolean will be set true and the winner will be investigated
     * 
    */
    public void checkWinner()
    {
        if(!player1.haveRemainingPokemon() || !player2.haveRemainingPokemon())
        {
            gameover = true;
            
            if(player1.haveRemainingPokemon())
                winnerPlayer1 = true;
            else
                winnerPlayer1 = false;
        }
    }

    /**
     * Return player2 object
     * @return player2 (Player object)
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * returns the gamestate
     * @return true if the game is over
     */
    public boolean isGameover() {
        return gameover;
    }
    
    /**
     * returns the winner, only valid if gameover is true
     * @return the winner of the game
     */
    public boolean isWinnerPlayer1() {
        return winnerPlayer1;
    }
}
