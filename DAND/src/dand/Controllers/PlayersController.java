/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dand.Controllers;

import dand.Models.GameData;
import dand.Models.Player;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tejan
 */
public class PlayersController {
    
    Scanner sc;
//    PlayersController playersController;
    public PlayersController() {
        sc = new Scanner(System.in);
        GameData.gamePlayers = new ArrayList<Player>();
        this.setPlayers();
        GameData.currentOneToThrow=1;
        
//        playersController = new PlayersController();
    }
    
    public void setPlayers(){
        try {
            System.out.println("Please enter how many players you want to create for game (minimum 2): ");
            boolean temp = true;
            while(temp) {
                GameData.noOfPlayers = sc.nextInt();
                if(GameData.noOfPlayers > 1) {
                    temp = false;
                }
            }
            System.out.println("Please enter one by one each players name as we ask following: \n ");
            this.AddPlayers();
            
        } catch (Exception e) {
        }
    }
    
    public boolean AddPlayers(){
        boolean temp = false;
        try {
            for(int i = 0; i < GameData.noOfPlayers; i++) {
                
                boolean x = true;
                while(x) {
                    String name = this.setPlayerName(i);
                    if(name != "" && name != null) {
                        Player player = new Player((i+1),name,false);            
                        GameData.gamePlayers.add(player);
                        name = "";
                        x = false;
                    }
                }
            }
        }
        catch (Exception e) {
             System.out.println("Player adding error." + e.getMessage());
        }
        return temp;
    }
    
    public String setPlayerName(int i) {
        System.out.println("Please enter name of Player - " + (i+1) + " : ");
        String name = sc.next();
        return name;
    }
    
    public boolean checkHowManyHaveCards(){
        boolean status = false;
        int cardPlayerCounter = 0;
        try {
            
        
        
        for(int i = 0; i < GameData.noOfPlayers; i++) {
            if(!GameData.cardController.checkIsCardOverOrNot(i)) {
                cardPlayerCounter++;
            }
        }
        if(cardPlayerCounter == 1) GameData.cardController.gameOver();
        else if(cardPlayerCounter > 1) return false;
        else if(cardPlayerCounter == 0) throw new Exception("There is some error in game");
        
        }
        catch(Exception e) {
            System.out.println("Exception caught : " + e.getMessage());
        }
        return status;
    }
}
