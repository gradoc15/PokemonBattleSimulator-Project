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
public class Pokemon
{
    //
    private int id;
    private String name;
    private Ability ability;
    private Nature nature;
    private Gender gender;
    private int lvl;
    private Move[] move = new Move[4];
    private boolean shiny;
    
    private Values basicValues;
    private Values iv;
    private Values ev;
    
    private int currentHP;
   
   
}
