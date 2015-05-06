package fr.iut.valence.tpdd.projet.abalone;

import java.util.Scanner;

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
    private Board board;
	private Scanner getCoordinatesX;
	private Scanner getCoordinatesY;

    /**
     * Constructor of a player.
     * @param number The player's number
     * @param color The color's number
     */
    public Player(int number, Color color, Board board) {
        this.playerNumber = number;
        this.PlayerColor = color;
        this.board = board;
        this.getCoordinatesX = new Scanner(System.in);
        this.getCoordinatesY = new Scanner(System.in);
    }
    
    /**
     * @return
     */
    public boolean moveBall(){//TODO throws
    	System.out.println("Abscissa choice :");
    	char bX = getCoordinatesX.nextLine().charAt(0);

    	System.out.println("Ordinate choice :");
    	int bY = getCoordinatesY.nextInt();
    	
    	Position begin = new Position(bX,bY);
    	
    	System.out.println("Abscissa choice :");
    	char eX = getCoordinatesX.nextLine().charAt(0);

    	System.out.println("Ordinate choice :");
    	int eY = getCoordinatesY.nextInt();
    	
    	Position end = new Position(eX,eY);
    	
    	board.moveBall(begin, end);
    	return true;
    	
    }
}
