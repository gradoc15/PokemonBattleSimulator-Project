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
     * @return 
     */
    public String getBez()
    {
        return bez;
    }

    /**
     * Returns the type (String) of the movve
     * @return 
     */
    public String getType()
    {
        return type;
    }


    /**
     * Returns the Category (String) of the move
     * @return 
     */
    public String getCat()
    {
        return cat;
    }


    /**
     * Returns the power (int) of the move
     * @return 
     */
    public int getPower()
    {
        return power;
    }

    /**
     * Returns the Accurance (int) of the move
     * @return 
     */
    public int getAccurance()
    {
        return accurance;
    }

    /**
     * Returns the name (String) of the move
     * @return 
     */
    public String toString()
    {
        return bez;
    }
    
    
}
