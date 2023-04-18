/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package dand.Models;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
//    @Override
//    public abstract String toString();
    private int id;
    private String cardNo;
    private int cardColor;
    private boolean isSpecial;
    private int priority;
    
    public Card() {
        
    }
    
    public Card(int id, String cardNo, int cardColor, boolean isSpecial) {
        this.id = id;
        this.cardNo = cardNo;
        this.cardColor = cardColor;
        this.isSpecial = isSpecial;
        this.priority = 0;
    }
    public Card(int id, String cardNo, int cardColor, boolean isSpecial, int priority) {
        this.id = id;
        this.cardNo = cardNo;
        this.cardColor = cardColor;
        this.isSpecial = isSpecial;
        this.priority = priority;
    }

    @Override
    public String toString() {
            return this.id +  " " + cardNo + " " + cardColor + " "  + isSpecial;
    }

    public int getCardColor() {
        return cardColor;
    }

    public String getCardNo() {
        return cardNo;
    }

    public int getId() {
        return id;
    }

    public void setCardColor(int cardColor) {
        this.cardColor = cardColor;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
    
    
}
