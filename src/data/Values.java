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

    /**
     * Returns the HP stat (int)
     * @return 
     */
    public int getHp()
    {
        return hp;
    }

    /**
     * Returns the Atk stat (int)
     * @return 
     */
    public int getAtk()
    {
        return atk;
    }

    /**
     * Returns the Def stat (int)
     * @return 
     */
    public int getDef()
    {
        return def;
    }

    /**
     * Returns the SpAtk stat
     * @return 
     */
    public int getSpAtk()
    {
        return spAtk;
    }

    /**
     * Returns the SpDef stat
     * @return 
     */
    public int getSpDef()
    {
        return spDef;
    }

    /**
     * returns the ini stat
     * @return 
     */
    public int getIni()
    {
        return ini;
    }
}
