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
public enum PokemonList
{
    BULNASAUR(1,"Bulbasaur", new Values(45, 49, 49, 65, 65, 45), Type.GRASS, Type.POISON, Ability.COMMING_SOON);
    
    private PokemonList(int id, String name, Values basicValues, Type type1, Type type2, Ability... abilities)
    {
        this.id = id;
        this.name = name;
        this.basicValues = basicValues;
        this.type1 = type1;
        this.type2 = type2;
        this.possibleAbilities = abilities;
    }
    private int id;
    private String name;
    private Values basicValues;
    private Type type1, type2;
    private Ability[] possibleAbilities;
    
    public static PokemonList getPokemonByID(int id) throws Exception
    {
        for(PokemonList pl: PokemonList.values())
            if(pl.id == id)
                return pl;
        
        throw new Exception("Pokémon not found");
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

    public Type getType1()
    {
        return type1;
    }

    public Type getType2()
    {
        return type2;
    }

    public Ability[] getPossibleAbilities()
    {
        return possibleAbilities;
    }
    
    
    
}
