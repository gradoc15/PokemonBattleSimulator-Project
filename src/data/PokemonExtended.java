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
public class PokemonExtended extends Pokemon
{
    private Values realStats;
    private int currentHP;
    private int movePP[] = new int[4];
    
    public PokemonExtended(int id, String name, Values basicValues, String type1, String type2, Ability ability)
    {
        super(id, name, basicValues, type1, type2, ability);
    }
    
    public PokemonExtended(data.Pokemon pkm)
    {
        
        super(pkm.getId(), pkm.getName(), pkm.getBasicValues(), pkm.getType1(), pkm.getType2(), pkm.getAbility());
        
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
    
    
    
}
