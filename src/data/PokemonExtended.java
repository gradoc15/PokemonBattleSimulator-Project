/*
 * To change this l"ice"nse header, choose L"ice"nse Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class PokemonExtended extends Pokemon
{
    private Values realStats;
    private boolean battleRdy = true;
    private int currentHP;
    private int movePP[] = new int[4];

    
    public PokemonExtended(int id, String name, Values basicValues, String type1, String type2, Ability ability)
    {
        super(id, name, basicValues, type1, type2, ability);
        
        
    }
    
    public PokemonExtended(data.Pokemon pkm)
    {
        
        super(pkm.getId(), pkm.getName(), pkm.getBasicValues(), pkm.getType1(), pkm.getType2(), pkm.getAbility());
        
        super.setNature(pkm.getNature());

        realStats = new Values((((2*super.getBasicValues().getHp()+super.getIv().getHp()+super.getEv().getHp()/4)*super.getLvl())/100)+5, 
                (int) ((int) ((((2*super.getBasicValues().getAtk()+super.getIv().getAtk()+super.getEv().getAtk()/4)*super.getLvl())/100)+5) 
                    * (super.getNature().getPositiv().equals(super.getNature().getNegativ()) ? 1 : super.getNature().getPositiv().equals(Stat.ATK) ? 1.1 : (super.getNature().getNegativ().equals(Stat.ATK) ? 0.9 : 1))), 
                (int) ((int) ((((2*super.getBasicValues().getDef()+super.getIv().getDef()+super.getEv().getDef()/4)*super.getLvl())/100)+5) 
                    * (super.getNature().getPositiv().equals(super.getNature().getNegativ()) ? 1 : super.getNature().getPositiv().equals(Stat.DEF) ? 1.1 : (super.getNature().getNegativ().equals(Stat.DEF) ? 0.9 : 1))), 
                (int) ((int) ((((2*super.getBasicValues().getSpAtk()+super.getIv().getSpAtk()+super.getEv().getSpAtk()/4)*super.getLvl())/100)+5) 
                    * (super.getNature().getPositiv().equals(super.getNature().getNegativ()) ? 1 : super.getNature().getPositiv().equals(Stat.SPATK) ? 1.1 : (super.getNature().getNegativ().equals(Stat.SPATK) ? 0.9 : 1))), 
                (int) ((int) ((((2*super.getBasicValues().getSpDef()+super.getIv().getSpDef()+super.getEv().getSpDef()/4)*super.getLvl())/100)+5) 
                    * (super.getNature().getPositiv().equals(super.getNature().getNegativ()) ? 1 : super.getNature().getPositiv().equals(Stat.SPDEF) ? 1.1 : (super.getNature().getNegativ().equals(Stat.SPDEF) ? 0.9 : 1))),
                (int) ((int) ((((2*super.getBasicValues().getIni()+super.getIv().getIni()+super.getEv().getIni()/4)*super.getLvl())/100)+5) 
                    * (super.getNature().getPositiv().equals(super.getNature().getNegativ()) ? 1 : super.getNature().getPositiv().equals(Stat.INIT) ? 1.1 : (super.getNature().getNegativ().equals(Stat.INIT) ? 0.9 : 1))));
        
        currentHP = realStats.getHp();
        
        for(int i = 0; i < movePP.length; i++)
            movePP[i] = 10;
    }
    
    public void minusHP(int amount)
    {
        currentHP-= amount;
        
        if(currentHP <= 0)
            battleRdy = false;
    }
    
    public int getHP()
    {
        return currentHP;
    }
    
    public void moveMake(int moveSlot, PokemonExtended enemy) throws Exception
    {
        if(movePP[moveSlot] <= 0)
            throw new Exception("There not enought pp");
        enemy.minusHP(calcDmg(moveSlot, enemy));
        movePP[moveSlot]--;
    }

    
    public int calcDmg(int moveSlot, PokemonExtended enemy)
    {
        
        return (int) ((int) ((int) 
                ((super.getMove()[moveSlot].getPower()*(super.getLvl()*2/5+2)
                    * (super.getMove()[moveSlot].getCat().equals("physic") ? realStats.getAtk()/enemy.getRealStats().getDef() : realStats.getSpAtk()/enemy.getRealStats().getSpDef()) +2) 
                    * (super.getMove()[moveSlot].getType().equals(super.getType1()) || super.getMove()[moveSlot].getType().equals(super.getType2()) ? 1.5 : 1))
                    * getTypeEffi(super.getMove()[moveSlot].getType(), enemy.getType1()))
                    * (!enemy.getType2().equals("none") ? getTypeEffi(super.getMove()[moveSlot].getType(), enemy.getType2()) : 1));
    }
    
    public double getTypeEffi(String atkType, String defType)
    {
        switch(atkType)
        {
            case "bug":
                switch(defType)
                {
                    case "grass":
                    case "psychic":
                    case "dark": return 2;
                    case "fire":
                    case "fighting":
                    case "flying":
                    case "poison":
                    case "ghost":
                    case "steel":
                    case "fairy": return 0.5;
                    default: return 1;
                }
            case "dark":
                switch(defType)
                {
                    case "psychic":
                    case "ghost": return 2;
                    case "fighting":
                    case "dark":
                    case "fairy": return 0.5;
                    default: return 1;
                }
            case "dragon":
                switch(defType)
                {
                    case "dragon": return 2;
                    case "steel": return 0.5;
                    case "fairy": return 0;
                    default: return 1;
                }
            case "electric":
                switch(defType)
                {
                    case "water":
                    case "flying": return 2;
                    case "grass":
                    case "electric":
                    case "dragon": return 0.5;
                    case "ground": return 0;
                    default: return 1;
                }
            case "fairy":
                switch(defType)
                {
                    case "fighting":
                    case "dragon":
                    case "dark": return 2;
                    case "fire":
                    case "poison":
                    case "steel": return 0.5;
                    default: return 1;
                }
            case "fighting":
                switch(defType)
                {
                    case "normal":
                    case "rock":
                    case "ice":
                    case "dark":
                    case "steel": return 2;
                    case "flying":
                    case "poison":
                    case "psychic":
                    case "bug":
                    case "fairy": return 0.5;
                    case "ghost": return 0;
                    default: return 1;
                }
            case "fire":
                switch(defType)
                {
                    case "grass":
                    case "ice":
                    case "bug":
                    case "steel": return 2;
                    case "fire":
                    case "water":
                    case "rock":
                    case "dragon": return 0.5;
                    default: return 1;
                }
            case "flying":
                switch(defType)
                {
                    case "fighting":
                    case "grass":
                    case "bug": return 2;
                    case "electric":
                    case "rock":
                    case "steel": return 0.5;
                    default: return 1;
                }
            case "ghost":
                switch(defType)
                {
                    case "ghost":
                    case "psychic": return 2;
                    case "dark": return 0.5;
                    case "normal": return 0;
                    default: return 1;
                }
            case "grass":
                switch(defType)
                {
                    case "water":
                    case "ground":
                    case "rock": return 2;
                    case "fire":
                    case "flying":
                    case "grass":
                    case "poison":
                    case "bug":
                    case "dragon":
                    case "steel": return 0.5;
                    default: return 1;
                }
            case "ground":
                switch(defType)
                {
                    case "fire":
                    case "poison":
                    case "electric":
                    case "rock":
                    case "steel": return 2;
                    case "grass":
                    case "bug": return 0.5;
                    case "flying": return 0;
                    default: return 1;
                }
            case "ice":
                switch(defType)
                {
                    case "flying":
                    case "grass":
                    case "ground":
                    case "dragon": return 2;
                    case "fire":
                    case "water":
                    case "ice":
                    case "steel": return 0.5;
                    default: return 1;
                }
            case "normal":
                switch(defType)
                {
                    case "rock":
                    case "steel": return 0.5;
                    case "ghost": return 0;
                    default: return 1;
                }
            case "poison":
                switch(defType)
                {
                    case "grass":
                    case "fairy": return 2;
                    case "poison":
                    case "ground":
                    case "rock":
                    case "ghost": return 0.5;
                    case "steel": return 0;
                    default: return 0;
                }
            case "psychic":
                switch(defType)
                {
                    case "fighting":
                    case "poison": return 2;
                    case "psychic":
                    case "steel": return 0.5;
                    case "dark": return 0;
                    default: return 1;
                }
            case "rock":
                switch(defType)
                {
                    case "fire":
                    case "flying":
                    case "ice":
                    case "bug": return 2;
                    case "fighting":
                    case "ground":
                    case "steel": return 0.5;
                    default: return 1;
                }
            case "steel":
                switch(defType)
                {
                    case "rock":
                    case "ice":
                    case "fairy": return 2;
                    case "fire":
                    case "water":
                    case "electric":
                    case "steel": return 0.5;
                    default: return 1;
                }
            case "water":
                switch(defType)
                {
                    case "fire":
                    case "ground":
                    case "rock": return 2;
                    case "water":
                    case "grass":
                    case "dragon": return 0.5;
                    default: return 1;
                }
            default: return 1;
        }
    }
    
    public double getTypeEffi(String atkType, String defType1, String defType2)
    {
        return getTypeEffi(atkType, defType1)* getTypeEffi(atkType, defType2);
    }

    public Values getRealStats()
    {
        return realStats;
    }

    public boolean isBattleRdy()
    {
        return battleRdy;
    }

    public int getCurrentHP()
    {
        return currentHP;
    }

    public int[] getMovePP()
    {
        return movePP;
    }
    
    
    
    
    
}
