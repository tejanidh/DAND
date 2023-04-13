/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dand.Controllers;

import dand.Models.GameData;
import dand.Models.Player;
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
                        Player player = new Player((i+1),name);            
                        GameData.gamePlayers.add(player);
                        name = "";
                        x = false;
                    }
                }
            }
        }
        catch (Exception e) {
             System.out.println("Player adding error.");
        }
        return temp;
    }
    
    public String setPlayerName(int i) {
        System.out.println("Please enter name of Player - " + (i+1) + " : ");
        String name = sc.next();
        return name;
    }
}
