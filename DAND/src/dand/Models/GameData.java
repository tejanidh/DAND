/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dand.Models;


import dand.Controllers.CardController;
import dand.Controllers.PlayersController;
import java.util.ArrayList;

/**
 *
 * @author tejan
 */
public class GameData {
    
    public static String[] colorList = {"Red","Blue","Yellow","Green"};

    public static ArrayList<Card> cardList = new  ArrayList<Card>();  
    public static ArrayList<Card> shuffledCardList = new  ArrayList<Card>();  
    public static ArrayList<Card> centeredCardList = new  ArrayList<Card>();
    public static int currentOneToThrow = 1;
    public static boolean playOrder = true;
    //true => ascending
    //false => reverse

    
    public static ArrayList<Player> gamePlayers;       
    public static ArrayList<Player> winnerGamePlayers;   
    
    public static int takeUpCard = 0;
    public static ArrayList<Card> takeUpCardList = new ArrayList<Card>();

    public static ArrayList<Player> currentGamePlayers;

    public static int noOfPlayers;
    public static int noOfCards = 0;
    public static int noOfDeck = 0;
    
    
    public static PlayersController playersController;
    public static CardController cardController;
    public static ArrayList<GameCardViewModel> GMVMList;
    public GameData() {
        
        
    }
    
    

    
    
    
    
}
