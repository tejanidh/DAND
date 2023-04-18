/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dand.Controllers;

import dand.Models.Card;
import dand.Models.GameCardViewModel;
import dand.Models.GameData;
import dand.Models.Player;
import java.security.Guard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author tejan
 */
public class CardController {
<<<<<<< HEAD
    Scanner sc;
    public CardController() {
        GameData.winnerGamePlayers = new ArrayList<Player>();
        GameData.centeredCardList = new ArrayList<Card>();
        sc = new Scanner(System.in);
        GameData.noOfDeck = (int)(GameData.noOfPlayers / 6); 
//        }
        if(GameData.noOfDeck  == 0) GameData.noOfDeck = 1;
        for(int i = 0; i < GameData.noOfDeck; i++){
           GameData.cardController.setCards();    
        }
        System.out.println(GameData.cardList);
        GameData.shuffledCardList = GameData.cardList;
        Collections.shuffle(GameData.shuffledCardList);
        System.out.println(GameData.shuffledCardList);
<<<<<<< HEAD
        GameData.cardController.dictatingCards();
        
    }
    
    
    
    public void setCards() {
        try {
            if(GameData.cardList.isEmpty()) {
            for(int i = 0; i < 4; i++){ // colors
                // for ADDING 0-9
                for(int j = 0; j < 10; j++) { // card numbers
                    GameData.noOfCards++;
                    Card card = new Card(GameData.noOfCards,String.valueOf(j),i,false);
                    GameData.cardList.add(card);
                    if(j != 0){
                        GameData.noOfCards++;
                        card = new Card(GameData.noOfCards,String.valueOf(j),i,false);
                        GameData.cardList.add(card);
                    }
//                    GameData.cardList.add(e)
                }
//                for(int j = 0; j < 2; j++) {
                    GameData.noOfCards++;
                    Card card = new Card(GameData.noOfCards,"+2",i,true,1);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards,"+2",i,true,1);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards,"+4",i,true,2);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards,"Reverse",i,true,3);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards,"Reverse",i,true,3);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards,"Skip",i,true,3);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards,"Skip",i,true,3);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards,"Wild",i,true,3);
                    GameData.cardList.add(card);
//                } 
            }
        }
        } catch (Exception e) {
            System.out.println("Exception caught in Main class : " + e.getMessage());
        }
        }
    }
        GameData.GMVMList = new ArrayList<GameCardViewModel>();
            GameData.GMVMList.add(new GameCardViewModel());
            GameData.GMVMList.get(i).playerId = GameData.gamePlayers.get(i).getId();
            GameData.GMVMList.get(i).gameStartCardList = new ArrayList<Card>();     
            GameData.GMVMList.get(i).currentCardList = new ArrayList<Card>(); 
        }
        
        
        //check at the last remaining card is there any special card or not.
        //if then changed it with dictating cards
        int remainCards = GameData.noOfCards % GameData.noOfPlayers; 
        
        for(int i = 0; i < remainCards; i++) {
            if(GameData.cardList.get(GameData.noOfCards - remainCards - i).isIsSpecial()) {
                for(int j = 0; j < GameData.noOfCards; j++) {
                    if(!GameData.cardList.get(j).isIsSpecial()) {
                        Card card = GameData.cardList.get(j);
                        GameData.cardList.set(i, GameData.cardList.get(GameData.noOfCards - remainCards - i));
                        GameData.cardList.set(GameData.noOfCards - remainCards - i,card);
                    }
                }
            }
            GameData.centeredCardList.add(GameData.cardList.get(GameData.noOfCards - remainCards - i));
        }

        for(int  j = 0; j < GameData.noOfCards - (GameData.noOfCards % GameData.noOfPlayers); j++) {
                GameData.GMVMList.get(j % GameData.noOfPlayers).gameStartCardList.add(GameData.cardList.get(j));
                GameData.GMVMList.get(j % GameData.noOfPlayers).currentCardList.add(GameData.cardList.get(j));
        }              
        
//        for(int i = 0; i < GameData.noOfPlayers; i++) {
//            System.out.println(GameData.GMVMList.get(i).gameStartCardList);
//        }
    }
    
    public void ThrowCard() {
        GameData.cardController.showCards();
        
        System.out.println("Please enter card id which card you want to throw : ");
        int cardId = sc.nextInt();
        if(GameData.cardController.checkInUserCard(cardId)) {
//            GameData.GMVMList.get(Ga)
            boolean throwC = false;
            if(GameData.cardList.get(cardId).isIsSpecial()) {
                getPreviousActionCard();
//                GameData.takeUpCard;
                GameData.takeUpCardList.add(GameData.cardList.get(cardId));
                switch (GameData.cardList.get(cardId).getCardNo()) {
                    case "+2":
                        GameData.takeUpCard += 2;
                        
                        break;
                    case "+4":
                        GameData.takeUpCard += 4;
                        break;
                }
                throwC = true;
            }
            else {
                if(GameData.cardController.checkCardWithLastCardColor(GameData.cardList.get(cardId),GameData.centeredCardList.get(GameData.centeredCardList.size() - 1)) || 
                    GameData.cardController.checkCardWithLastCardNumber(GameData.cardList.get(cardId),GameData.centeredCardList.get(GameData.centeredCardList.size() - 1))) {
                    throwC = true;
                }
            }
            
            if(throwC) {
                GameData.centeredCardList.add(GameData.GMVMList.get(GameData.currentOneToThrow - 1).currentCardList.get(GameData.cardController.getCardIndexFromCurrentListOfUser(cardId)));
                    GameData.GMVMList.get(GameData.currentOneToThrow - 1).currentCardList.remove(GameData.cardController.getCardIndexFromCurrentListOfUser(cardId));
            }
            
            GameData.cardController.UpdateCurrentCardThrower();

        }

    }
    
    public int getCardIndexFromCurrentListOfUser(int cardId) {
        int temp = 0;
        for(int i = 0; i < GameData.GMVMList.get(GameData.currentOneToThrow - 1).currentCardList.size(); i++) {
            if(GameData.GMVMList.get(GameData.currentOneToThrow - 1).currentCardList.get(i).getId() == cardId)
                return i;
        }
        return temp;
    }
    
    public boolean checkSpecialCardAvailableOrNot() {
        boolean temp = false;
        String previousCard  = "";     
        int previousCardPriority  = 0;

        if(GameData.takeUpCardList.size() > 0) {
            previousCard = GameData.takeUpCardList.get(GameData.takeUpCardList.size() - 1).getCardNo();            
            previousCardPriority = GameData.takeUpCardList.get(GameData.takeUpCardList.size() - 1).getPriority();
        }
        for(int i = 0; i < GameData.GMVMList.get(GameData.currentOneToThrow - 1).currentCardList.size(); i++) {
            if(GameData.GMVMList.get(GameData.currentOneToThrow - 1).currentCardList.get(i).isIsSpecial() && 
                    GameData.GMVMList.get(GameData.currentOneToThrow - 1).currentCardList.get(i).getPriority() >= previousCardPriority) {
                temp = true;
                break;
                
            }
        }
        return temp;
    }
    
    public int getPreviousCard() {
//        Card card = new Card();
        if(GameData.centeredCardList.size() != 0)
            return GameData.centeredCardList.size() - 1;
        return -1;
    }
    
    public int getPreviousCard(int position) {
//        Card card = new Card();
        if(GameData.centeredCardList.size() != 0)
            return position - 1;
        return -1;
    }
    
    public int getPreviousActionCard() {
        for(int i = GameData.centeredCardList.size() - 1; i > 0; i--){
            if(GameData.centeredCardList.get(i).isIsSpecial()) {
                return i;
            }
        } 
        return -1;
    }
    
    public int getPreviousActionPri2Or3Card() {
        for(int i = GameData.centeredCardList.size() - 1; i > 0; i--){
            if(GameData.centeredCardList.get(i).isIsSpecial() && (GameData.centeredCardList.get(i).getPriority()== 2 || GameData.centeredCardList.get(i).getPriority()== 3) ) {
                return i;
            }
        } 
        return -1;
    }
    
    public boolean checkInUserCard(int cardNo) {
        boolean status = false;
        for(int i = 0; i < GameData.GMVMList.get(GameData.currentOneToThrow - 1).currentCardList.size(); i++) {
            if(GameData.GMVMList.get(GameData.currentOneToThrow - 1).currentCardList.get(i).getId() == cardNo) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkCardWithLastCardColor(Card currentThrown, Card lastCard) {
        
        return currentThrown.getCardColor() == lastCard.getCardColor();
    }
    
    public boolean checkCardWithLastCardNumber(Card currentThrown, Card lastCard) {      
        return currentThrown.getCardNo() == lastCard.getCardNo();
    }
    
    public void showCards() {
        for(int i = 0; i < GameData.GMVMList.size(); i++) {
            if(GameData.GMVMList.get(i).playerId == GameData.currentOneToThrow && GameData.cardController.checkIsCardOverOrNot()) {
                //print player name
                for(int k = 0; k < GameData.gamePlayers.size(); k++) {
                        if(GameData.currentOneToThrow == GameData.gamePlayers.get(i).getId()) {
                            System.out.println("Now it's " + GameData.gamePlayers.get(i).getName() + ":");
                            break;
                        }
                    }
                for(int j = 0; j < GameData.GMVMList.get(i).currentCardList.size(); j++) {
                    System.out.println(GameData.GMVMList.get(i).currentCardList.get(j).getId() + " " + GameData.GMVMList.get(i).currentCardList.get(j).getCardNo() + " " + GameData.colorList[GameData.GMVMList.get(i).currentCardList.get(j).getCardColor()]);
                }
            }
        }
    }
    
    public void UpdateCurrentCardThrower() {
        if(GameData.playOrder) GameData.cardController.UpdateClockwiseOrder();
        else GameData.cardController.UpdateAntiClockwiseOrder();
        if(GameData.cardController.checkIsCardOverOrNot(GameData.currentOneToThrow)) GameData.cardController.UpdateCurrentCardThrower();
    }
    
    public void UpdateClockwiseOrder() {
        if(GameData.currentOneToThrow == GameData.noOfPlayers)
           GameData.currentOneToThrow = GameData.gamePlayers.get(0).getId();
       else GameData.currentOneToThrow++;
    }
    
    public void UpdateAntiClockwiseOrder() {
        if(GameData.currentOneToThrow == 1)
           GameData.currentOneToThrow = GameData.gamePlayers.get(GameData.gamePlayers.size() - 1).getId();
       else GameData.currentOneToThrow--;
    }
    
    public boolean checkIsCardOverOrNot() {
        boolean temp = false;
        for(int i = 0; i < GameData.noOfPlayers; i++ ) {
            if(GameData.cardController.checkIsCardOverOrNot(i)) {
                return true;
            }
        }
        return temp;
    }
    
    public boolean checkIsCardOverOrNot(int playerId) {
        boolean temp = false;
        if(GameData.gamePlayers.get(playerId).isIsCardOver()) {
            return true;
        }
        
        return temp;
    }
    
    public void changePlayOrder(){
        GameData.playOrder = !GameData.playOrder;
    }
    
    public void updateiIsCardOver(int playerId, boolean status) {
        GameData.gamePlayers.get(playerId).setIsCardOver(status);
    }
    
    public void gameOver() {
        showCards();
    }
    
    public void showWinners() {
        if(GameData.cardController.checkUpdateInWinner()) {
            for(int i = 0; i < GameData.gamePlayers.size(); i++) {
                if(GameData.gamePlayers.get(i).isIsCardOver()) {
                    boolean temp = false;
                    int checkOccurence = 0;
                    int updatePosition = 0;
                    for(int j = 0; j < GameData.winnerGamePlayers.size(); j++) {
                        if(GameData.winnerGamePlayers.get(j).getId() == GameData.gamePlayers.get(i).getId()) {
                            checkOccurence++;
                            updatePosition = j;
                            break;
                        }
                    }
                    if(checkOccurence == 0) {
                        GameData.winnerGamePlayers.add(GameData.gamePlayers.get(updatePosition));
                    }
                }
            }
        }
        if(GameData.winnerGamePlayers.size() > 0) {
            System.out.println("Winners in line by line : ");
            System.out.println("No.           Name");
            for(int i = 0; i < GameData.winnerGamePlayers.size(); i++) {
                System.out.print((i + 1) + "         " + GameData.winnerGamePlayers.get(i).getName());
            }
        }
    }
    
    
  
    
    public boolean checkUpdateInWinner() {
        int checkUpdatedWinner = 0;
        int noOfWinner = GameData.winnerGamePlayers.size();
        for(int i = 0; i < GameData.gamePlayers.size(); i++){
            if(GameData.gamePlayers.get(i).isIsCardOver()) checkUpdatedWinner++;
        }
        if(checkUpdatedWinner == noOfWinner) return false;
        else return true;
    }
    
}
