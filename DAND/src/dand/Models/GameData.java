/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dand.Models;

import dand.GameCardViewModel;
import java.util.ArrayList;

/**
 *
 * @author tejan
 */
public class GameData {
    
    public static String[] colorList = {"Red","Blue","Yellow","Green"};

    public static ArrayList<Card> cardList = new  ArrayList<Card>();  
    public static ArrayList<Card> shuffledCardList = new  ArrayList<Card>();

    
    public static ArrayList<Player> gamePlayers;
    public static int noOfPlayers;
    public static int noOfCards = 0;
    public static int noOfDeck = 0;
    
    public static ArrayList<GameCardViewModel> GMVMList;
    public GameData() {
    }
    
    

    
    
    
    
}
