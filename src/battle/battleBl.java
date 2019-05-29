/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import data.Pokemon;

/**
 *
 * @author User
 */
public class battleBl
{
    private data.PokemonExtended ownTeam[];
    private boolean myTurn;
    private int actSlot;

    public battleBl(data.PokemonExtended ownTeam[])
    {
        this.ownTeam = ownTeam;
    }

    public void setActSlot(int actSlot)
    {
        this.actSlot = actSlot;
    }

    public int getActSlot()
    {
        return actSlot;
    }
    
    
    
    

    
    
}
