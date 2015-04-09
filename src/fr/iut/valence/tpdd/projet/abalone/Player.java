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

    /* TODO JAVADOC. */
    public Player(int number, Color color) {
        this.playerNumber = number;
        this.PlayerColor = color;
    }
}
