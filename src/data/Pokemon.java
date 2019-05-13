/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author User
 */
public class Pokemon
{
    public Pokemon(PokemonList pl)
    {
        id = pl.getId();
        name = pl.getName();
        basicValues = pl.getBasicValues();
        
        iv = new Values(31, 31, 31, 31, 31, 31);
        ev = new Values(0, 0, 0, 0, 0, 0);
        lvl = 100;
        ability = pl.getPossibleAbilities()[0];
    }
    
    private final int id;
    private final String name;
    private final Values basicValues;
    
    private Ability ability;
    private Nature nature;
    private Gender gender;
    private int lvl;
    private Move[] move = new Move[4];
    private boolean shiny;
    
    private Values iv;
    private Values ev;
    
    private int currentHP;
   
   
}
