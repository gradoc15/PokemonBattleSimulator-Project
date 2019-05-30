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
public enum Nature
{
    HARDY("Hardy",Stat.ATK,Stat.ATK),
    LONELY("Lonely",Stat.ATK,Stat.DEF),
    ADAMANT("Adamant", Stat.ATK, Stat.DEF),
    NAUGHTY("Naughty", Stat.ATK, Stat.SPDEF),
    BRAVE("Brave",Stat.ATK,Stat.INIT),
    
    BOLD("Bold", Stat.DEF, Stat.ATK),
    DOCILE("Docile",Stat.DEF,Stat.DEF),
    IMPISH("Impish",Stat.DEF,Stat.SPATK),
    LAX("Lax", Stat.DEF, Stat.SPDEF),
    RELAXED("Relaxed", Stat.DEF,Stat.INIT),
    
    MODEST("Modest",Stat.SPATK,Stat.ATK),
    MILD("Mild",Stat.SPATK,Stat.DEF),
    BASHFUL("Bashful",Stat.SPATK,Stat.SPATK),
    RASH("Rash",Stat.SPATK,Stat.SPDEF),
    QUIET("Quiet",Stat.SPATK,Stat.INIT),
    
    CALM("Calm", Stat.SPDEF,Stat.ATK),
    GENTLE("Gentle",Stat.SPDEF,Stat.DEF),
    CAREFUL("Careful",Stat.SPDEF,Stat.SPATK),
    QUIRKY("Quirky",Stat.SPDEF,Stat.SPDEF),
    SASSY("Sassy",Stat.SPDEF,Stat.INIT),
    
    TIMID("Timid",Stat.INIT,Stat.ATK),
    HASTY("Hasty",Stat.INIT,Stat.DEF),
    JOLLY("Jolly",Stat.INIT,Stat.SPATK),
    NAIVE("Naive",Stat.INIT,Stat.SPDEF),
    SERIOUS("Serious",Stat.INIT,Stat.INIT);
    
    private Nature(String bez, Stat plus, Stat minus)
    {
        this.bez = bez;
        this.negativ = minus;
        this.positiv = plus;
    }
    
    private String bez;
    private Stat positiv, negativ;

    /**
     * Returns the Stat which gets boosted by 10%
     * @return boosted stat
     */
    public Stat getPositiv()
    {
        return positiv;
    }

    /**
     * Returns the Stat which gets lowerd by 10%
     * @return lowered stat
     */
    public Stat getNegativ()
    {
        return negativ;
    }
    
    
    
}
