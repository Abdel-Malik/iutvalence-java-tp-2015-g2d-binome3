package fr.iut.valence.tpdd.projet.abalone;

import java.util.Scanner;

/**
 * Complete game: players and board.
 *
 * @author blouinm and bouhassa
 * @version 1.0
 */
public class Game {
    /** Constant of the number of turn. */
    public static final int DEFAULT_TURN = 0;
    /** The first player. */
    private final Player player1;
    
    /** The second player. */
    private final Player player2;
    
    /** The board of the game. */
    private final Board  gameBoard;
    
    /** Number of turn of the game. */
    private int nbTurn;
    
    /** The current player of the game. */
    private Player currentPlayer;
    
	private Scanner getCoordinatesX;
	private Scanner getCoordinatesY;

    /**
     * Create a new party with the players.
	 *
     * @param p1    The first player
     * @param p2    The second player
     */
    public Game(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.gameBoard = new Board();
        this.nbTurn = DEFAULT_TURN;
        this.getCoordinatesX = new Scanner(System.in);
        this.getCoordinatesY = new Scanner(System.in);
    }

    /**
     * Get current player.
     *
     * @return The current player
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Get the number of turn.
     *
     * @return The number of turn
     */
    public int getNbTurn() {
        return this.nbTurn;
    }

    /**
     * Increase the number of turn.
     */
    public void increaseNbTurn() {
        this.nbTurn++;
    }
    
    public Board getBoard(){
    	return this.gameBoard;
    }
    
    /**
     * Move Ball.
     *
     * @param start Case of start
     * @param end   Case of end
     */
    
    public boolean selectBall(){//TODO throws
    	System.out.println("Abscissa choice :");
    	char bX = getCoordinatesX.nextLine().charAt(0);

    	System.out.println("Ordinate choice :");
    	int bY = getCoordinatesY.nextInt();
    	
    	Position begin = new Position((int) (bX-65),bY);
    	
    	System.out.println("Abscissa choice :");
    	char eX = getCoordinatesX.nextLine().charAt(0);

    	System.out.println("Ordinate choice :");
    	int eY = getCoordinatesY.nextInt();
    	
    	Position end = new Position((int) (eX-65),eY);
    	
    	this.moveBall(begin, end);
    	return true;
    	
    }
    public void moveBall(Position start, Position end) {
    	if(this.gameBoard.getCase(start).getBall() == Color.OTHER){
    		System.out.println("Aucune boule");
    	}
    	else{
    		this.gameBoard.getCase(end).putBall(this.gameBoard.getCase(start).getBall());
    		this.gameBoard.getCase(start).removeBall();
    	}
    }

}
