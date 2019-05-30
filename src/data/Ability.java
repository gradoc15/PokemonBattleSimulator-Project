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
public class Ability
{
    private String bez;
    public Ability(String bez)
    {
        this.bez = bez;
    }

    /**
     * Returns the name of the ability
     * @return the name of the ability (string)
     */
    public String getBez()
    {
        return bez;
    }
    
    /**
     * Returns the name of the ability
     * @return @return the name of the ability (string)
     */
    public String toString()
    {
        return bez;
    }
    
}
