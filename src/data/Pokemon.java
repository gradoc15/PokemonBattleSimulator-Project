/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Pokemon
{
    /**
     * Constructor
     * @param id
     * @param name
     * @param basicValues
     * @param type1
     * @param type2
     * @param ability 
     */
    public Pokemon(int id, String name, Values basicValues, String type1, String type2, Ability ability)
    {
        this.id = id;
        this.name = name;
        this.basicValues = basicValues;
        
        iv = new Values(31, 31, 31, 31, 31, 31);
        ev = new Values(0, 0, 0, 0, 0, 0);
        lvl = 100;
        
        this.type1 = type1;
        this.type2 = type2;
        
        this.ability = ability;
    }

    protected int id;
    protected  String name;
    protected  Values basicValues;
    
    protected Ability ability;
    protected Nature nature;
    protected Gender gender;
    protected int lvl;
    protected Move[] move = new Move[4];
    protected boolean shiny;
    protected String type1, type2;
    
    protected Values iv;
    protected Values ev;
    
    
    /**
     * Set the ability (String) of the pokemon
     * @param ability the ability which is wanted to set
     */
    public void setAbility(Ability ability)
    {
        this.ability = ability;
    }

    /**
     * Set the nature (Nature) of the pokemon
     * @param nature the nature which is wanted to set
     */
    public void setNature(Nature nature)
    {
        this.nature = nature;
    }

    /**
     * Set the gender (Gender) of the pokemon
     * @param gender the gender which is wanted to set
     */
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    /**
     * set the level (int) of the pokemon
     * @param lvl the level which is wanted to set
     */
    public void setLvl(int lvl)
    {
        this.lvl = lvl;
    }

    /**
     * set the moves (Move[]) of the pokemon
     * @param move the moves which are wanted to set
     */
    public void setMove(Move[] move)
    {
        this.move = move;
    }

    /**
     * Set the shiny boolean of pokemon
     * @param shiny true if the pokemon should be shiny
     */
    public void setShiny(boolean shiny)
    {
        this.shiny = shiny;
    }

    /**
     * Set the primary type (String) of the pokemon
     * @return primary type (string)
     */
    public String getType1()
    {
        return type1;
    }

    /**
     * Set the secondary type of the Pokemon
     * @return secondary type (string)
     */
    public String getType2()
    {
        return type2;
    }
    
    /**
     * Set the Iv (Values) of the pokemon
     * @param iv iv (values)
     */
    public void setIv(Values iv)
    {
        this.iv = iv;
    }

    /**
     * Set the ev (Value) of the pokemon
     * @param ev evs (values) which sould be set
     */
    public void setEv(Values ev)
    {
        this.ev = ev;
    }

    /**
     * Get the id (int) of the pokemon
     * @return the id of the pokemon (int)
     */
    public int getId()
    {
        return id;
    }

    /**
     * get the name (String) of the pokemon
     * @return  name of the pokemon
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the basicvalues (Values) of the pokemon
     * @return the basicvalues
     */
    public Values getBasicValues()
    {
        return basicValues;
    }

    /**
     * Get the ability (Ability) of the pokemon
     * @return the ability
     */
    public Ability getAbility()
    {
        return ability;
    }

    /**
     * get the nature (Nature) of the pokemon
     * @return the nature 
     */
    public Nature getNature()
    {
        return nature;
    }

    /**
     * Get the gender (Gender) of the pokemon
     * @return the gender
     */
    public Gender getGender()
    {
        return gender;
    }

    /**
     * Get the lvl (int) of the pokemon
     * @return the level
     */
    public int getLvl()
    {
        return lvl;
    }

    /**
     * Get the moves (Move[]) of the pokemon
     * @return all moves 
     */
    public Move[] getMove()
    {
        return move;
    }

    /**
     * Get the shiny status (boolean) of the pokemon
     * @return shiny status (true = shiny)
     */
    public boolean isShiny()
    {
        return shiny;
    }

    /**
     * Get the iv (Value) of the pokemon
     * @return the ivs (value)
     */
    public Values getIv()
    {
        return iv;
    }

    /**
     * get the ev (Value) of the pokemon
     * @return the evs (value)
     */
    public Values getEv()
    {
        return ev;
    }


    /**
     * Returns the name of the pokemon
     * @return the name of the pokemon
     */
    public String toString()
    {
        return name;
    }
    
    
    
    
   
   
}
