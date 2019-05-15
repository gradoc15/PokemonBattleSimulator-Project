
import data.Pokemon;
import data.PokemonList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class main
{
    public static void main(String[] args)
    {
        Pokemon p = new Pokemon(PokemonList.BULNASAUR);
        gui.PokeEditor pe = new gui.PokeEditor(null, true);
        pe.setVisible(true);
    }
}
