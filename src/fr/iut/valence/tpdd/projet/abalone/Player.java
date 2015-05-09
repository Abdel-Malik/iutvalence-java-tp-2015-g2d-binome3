package fr.iut.valence.tpdd.projet.abalone;

/**
 * Player represented by a number and a color.
 *
 * @author blouinm and bouhassa
 * @version 1.0
 */
public class Player {
    /** Player's number. */
    private final int   playerNumber;
    /** Player's color (black or white). */
    private final Color PlayerColor;


    /**
     * Constructor of a player.
     * 
     * @param number The player's number
     * @param color The player's color
     */
    public Player(int number, Color color) {
        this.playerNumber = number;
        this.PlayerColor = color;
    }
    
    /**
     * to get the number of the player.
     * @return the player's number
     */
    public int getPlayerNumber(){
    	return this.playerNumber;
    }
    
    /**
     * to get the color of the player.
     * @return the player's color
     */
    public Color getPlayerColor(){
    	return this.PlayerColor;
    }
 
}
