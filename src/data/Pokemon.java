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
    
    private Values stats;
    private int currentHP;
    
    public void updateStats()
    {
        stats.setHp((2*basicValues.getHp()+iv.getHp()+ev.getHp()/4)/100+5);
        stats.setAtk((2*basicValues.getAtk()+iv.getAtk()+ev.getAtk()/4)/100+5);
        stats.setDef((2*basicValues.getDef()+iv.getDef()+ev.getDef()/4)/100+5);
        stats.setSpAtk((2*basicValues.getSpAtk()+iv.getSpAtk()+ev.getSpAtk()/4)/100+5);
        stats.setSpDef((2*basicValues.getSpDef()+iv.getSpDef()+ev.getSpDef()/4)/100+5);
        stats.setIni((2*basicValues.getIni()+iv.getIni()+ev.getIni()/4)/100+5);
    }

    public void setAbility(Ability ability)
    {
        this.ability = ability;
    }

    public void setNature(Nature nature)
    {
        this.nature = nature;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public void setLvl(int lvl)
    {
        this.lvl = lvl;
    }

    public void setMove(Move[] move)
    {
        this.move = move;
    }

    public void setShiny(boolean shiny)
    {
        this.shiny = shiny;
    }

    public void setIv(Values iv)
    {
        this.iv = iv;
    }

    public void setEv(Values ev)
    {
        this.ev = ev;
    }

    public void setCurrentHP(int currentHP)
    {
        this.currentHP = currentHP;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Values getBasicValues()
    {
        return basicValues;
    }

    public Ability getAbility()
    {
        return ability;
    }

    public Nature getNature()
    {
        return nature;
    }

    public Gender getGender()
    {
        return gender;
    }

    public int getLvl()
    {
        return lvl;
    }

    public Move[] getMove()
    {
        return move;
    }

    public boolean isShiny()
    {
        return shiny;
    }

    public Values getIv()
    {
        return iv;
    }

    public Values getEv()
    {
        return ev;
    }

    public Values getStats()
    {
        return stats;
    }

    public int getCurrentHP()
    {
        return currentHP;
    }
    
    
   
   
}
