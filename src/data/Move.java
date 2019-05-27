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
    /*
        st.executeUpdate("CREATE TABLE move"
                + " ("
                + " MID INTEGER PRIMARY KEY,"
                + " Bez VARCHAR(30),"
                + " Type VARCHAR(15),"
                + " Category VARCHAR(30),"
                + " Power INTEGER,"
                + " Accurance INTEGER);");
    */
    
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

    public String getBez()
    {
        return bez;
    }

    public void setBez(String bez)
    {
        this.bez = bez;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getCat()
    {
        return cat;
    }

    public void setCat(String cat)
    {
        this.cat = cat;
    }

    public int getPower()
    {
        return power;
    }

    public void setPower(int power)
    {
        this.power = power;
    }

    public int getAccurance()
    {
        return accurance;
    }

    public void setAccurance(int accurance)
    {
        this.accurance = accurance;
    }
    
    public String toString()
    {
        return bez;
    }
    
    
}
