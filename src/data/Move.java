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
public class Move
{
    private String bez;
    private String type;
    private String cat;
    private int power;
    private int accurance;

    public Move(String bez, String type, String cat, int power, int accurance)
    {
        this.bez = bez;
        this.type = type;
        this.cat = cat;
        this.power = power;
        this.accurance = accurance;
    }

    /**
     * Returns name (String)  of the move
     * @return name (String)  of the move
     */
    public String getBez()
    {
        return bez;
    }

    /**
     * Returns the type (String) of the movve
     * @return type (String) of the move
     */
    public String getType()
    {
        return type;
    }


    /**
     * Returns the Category (String) of the move
     * @return Category (String) of the move
     */
    public String getCat()
    {
        return cat;
    }


    /**
     * Returns the power (int) of the move
     * @return power (int) of the move
     */
    public int getPower()
    {
        return power;
    }

    /**
     * Returns the Accurance (int) of the move
     * @return Accurance (int) of the move
     */
    public int getAccurance()
    {
        return accurance;
    }

    /**
     * Returns the name (String) of the move
     * @return name (String) of the move
     */
    public String toString()
    {
        return bez;
    }
    
    
}
