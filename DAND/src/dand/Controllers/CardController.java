/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dand.Controllers;

import dand.Models.Card;
import dand.Models.GameCardViewModel;
import dand.Models.GameData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author tejan
 */
public class CardController {

    Scanner sc = new Scanner(System.in);

    public CardController() {
        GameData.noOfDeck = (int) (GameData.noOfPlayers / 6);
//        }
        if (GameData.noOfDeck == 0) {
            GameData.noOfDeck = 1;
        }
        for (int i = 0; i < GameData.noOfDeck; i++) {
            this.setCards();
        }
        System.out.println(GameData.cardList);
        GameData.shuffledCardList = GameData.cardList;
        Collections.shuffle(GameData.shuffledCardList);
        System.out.println(GameData.shuffledCardList);
        this.dictatingCards();
        this.ThrowCard();
    }

    public void ThrowCard() {
        int position=-1;
        System.out.println(GameData.GMVMList.get(GameData.currentOneToThrow).currentCardList);
        System.out.println("You Have Following cards to throw");
        System.out.print("Enter Card Number: ");
        int userCard = sc.nextInt();
        for (int i = 0; i < GameData.GMVMList.get(GameData.currentOneToThrow).currentCardList.size(); i++) {
            if(GameData.GMVMList.get(GameData.currentOneToThrow).currentCardList.get(i).getId()==userCard ){
                System.out.println("Okk , the card is correct");
                position=i;
                break;
            }
        }
        GameData.GMVMList.get(GameData.currentOneToThrow).currentCardList.remove(position);
        System.out.println("The new number after removal of  the user thrown ");
        System.out.println("after" + "\n" + GameData.GMVMList.get(GameData.currentOneToThrow).currentCardList);
        
    }

    public void setCards() {
        try {
            if (GameData.cardList.isEmpty()) {
                for (int i = 0; i < 4; i++) { // colors
                    // for ADDING 0-9
                    for (int j = 0; j < 10; j++) { // card numbers
                        GameData.noOfCards++;
                        Card card = new Card(GameData.noOfCards, String.valueOf(j), i, false);
                        GameData.cardList.add(card);
                        if (j != 0) {
                            GameData.noOfCards++;
                            card = new Card(GameData.noOfCards, String.valueOf(j), i, false);
                            GameData.cardList.add(card);
                        }
//                  GameData.cardList.add(e)
                    }
                    //  for(int j = 0; j < 2; j++) {
                    GameData.noOfCards++;
                    Card card = new Card(GameData.noOfCards, "+2", i, true);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards, "+2", i, true);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards, "+4", i, true);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards, "Reverse", i, true);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards, "Reverse", i, true);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards, "Stop", i, true);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards, "Stop", i, true);
                    GameData.cardList.add(card);
                    GameData.noOfCards++;
                    card = new Card(GameData.noOfCards, "Wild", i, true);
                    GameData.cardList.add(card);
//                } 
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught in Main class : " + e.getMessage());
        }
        for (int i = 0; i < GameData.cardList.size(); i++) {
            System.out.println(GameData.cardList.get(i).toString());
        }

    }

    public void dictatingCards() {
        GameData.GMVMList = new ArrayList<GameCardViewModel>();

        for (int i = 0; i < GameData.noOfPlayers; i++) {
            GameData.GMVMList.add(new GameCardViewModel());
            GameData.GMVMList.get(i).playerId = GameData.gamePlayers.get(i).getId();
            GameData.GMVMList.get(i).gameStartCardList = new ArrayList<Card>();
            GameData.GMVMList.get(i).currentCardList = new ArrayList<Card>();

        }

        //check at the last remaining card is there any special card or not.
        //if then changed it with dictating cards
        int remainCards = GameData.noOfCards % GameData.noOfPlayers;

        for (int i = 0; i < remainCards; i++) {
            if (GameData.cardList.get(GameData.noOfCards - remainCards - i).isIsSpecial()) {
                for (int j = 0; j < GameData.noOfCards; j++) {
                    if (!GameData.cardList.get(j).isIsSpecial()) {
                        Card card = GameData.cardList.get(j);
                        GameData.cardList.set(i, GameData.cardList.get(GameData.noOfCards - remainCards - i));
                        GameData.cardList.set(GameData.noOfCards - remainCards - i, card);
                    }
                }
            }
        }
        System.out.println(GameData.cardList);
        int dictateCardNo = 0;
        for (int i = 0; (i < GameData.noOfPlayers) && dictateCardNo <= GameData.noOfCards; i++) {
            for (int j = 0; j < (int) (GameData.noOfCards / GameData.noOfPlayers); j += GameData.noOfPlayers) {
                GameData.GMVMList.get(i).gameStartCardList.add(GameData.cardList.get(j));
                GameData.GMVMList.get(i).currentCardList.add(GameData.cardList.get(j));

            }
            System.out.println(GameData.GMVMList.get(i).gameStartCardList);
        }

    }
}
