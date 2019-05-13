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
public class Values
{
    int hp;
    int atk;
    int def;
    int spAtk;
    int spDef;
    int ini;

    public Values(int hp, int atk, int def, int spAtk, int spDef, int ini)
    {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.ini = ini;
    }

    public int getHp()
    {
        return hp;
    }

    public int getAtk()
    {
        return atk;
    }

    public int getDef()
    {
        return def;
    }

    public int getSpAtk()
    {
        return spAtk;
    }

    public int getSpDef()
    {
        return spDef;
    }

    public int getIni()
    {
        return ini;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public void setAtk(int atk)
    {
        this.atk = atk;
    }

    public void setDef(int def)
    {
        this.def = def;
    }

    public void setSpAtk(int spAtk)
    {
        this.spAtk = spAtk;
    }

    public void setSpDef(int spDef)
    {
        this.spDef = spDef;
    }

    public void setIni(int ini)
    {
        this.ini = ini;
    }
    
    
}
