package dand;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * 
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {

	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * A constructor that allows you to set the player's unique ID
	 * @param name the unique ID to assign to this player.
	 */
	public Player(String name) {
		// TODO - implement Player.Player
		throw new UnsupportedOperationException();
	}

	/**
	 * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
	 * with logic to play your game.
	 */
	public abstract void play();

}