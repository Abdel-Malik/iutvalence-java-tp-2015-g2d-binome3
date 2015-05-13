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
	private Scanner nbBallMoving;

    /**
     * Create a new party with the players.
	 *
     * @param p1    The first player
     * @param p2    The second player
     */
    public Game(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;
        this.gameBoard = new Board();
        this.nbTurn = DEFAULT_TURN;
        this.getCoordinatesX = new Scanner(System.in);
        this.getCoordinatesY = new Scanner(System.in);
        this.nbBallMoving = new Scanner(System.in);
        }

    /**
     * Change current player.
     */
    public void changeCurrentPlayer() { //TODO equals
        if(this.currentPlayer == this.player1){
        	this.currentPlayer = player2;
        }
        else{
        	this.currentPlayer = player1;
        }
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
    
    /**
     * Get the board of the game
     * @return the board of the game
     */
    public Board getBoard(){
    	return this.gameBoard;
    }
    
    /**
     * Choose how many balls you want to move. 
     * @throws WrongBallSelectedException
     */
    public void nbBall() throws WrongBallSelectedException{ 
    	System.out.println("How many ball would you move ?");
    	int numberOfBall = nbBallMoving.nextInt();
    	if(numberOfBall == 1){
			selectOneBall();
    	}
    	if(numberOfBall == 2){
    		selectTwoBalls();
    	}
    }
    
    
    private void selectTwoBalls() {
		
		
	}

	/**
     * @throws WrongBallSelectedException
     */
    public void selectOneBall() throws WrongBallSelectedException{ 
    	Move movePossible;
    	Position begin;
    	do{
	    	System.out.println("\n\nAbscissa choice :");
	    	char bX = getCoordinatesX.nextLine().charAt(0);
	
	    	System.out.println("Ordinate choice :");
	    	int bY = getCoordinatesY.nextInt();
	    	
	    	begin = new Position((int) (bX-65),(bY-1));
	    	
	    	if(this.gameBoard.getCase(begin).getBall() != this.currentPlayer.getPlayerColor()){
	    		throw new WrongBallSelectedException();
	    	}
	    	
	
	    	movePossible = new Move(begin, this);
	    	
	    	if(movePossible.getMovePos() == 0){
	    		System.out.println("Aucun déplacement possible, choisissez une autre boule");
	    	}
	    	else{
	    		System.out.println("Déplacement possible : ");
	    		for(int a=0;a< movePossible.getMovePos();a++){
	    			System.out.println(movePossible.getMovingPossibility(a));
	    		}
	    	}
    	}while(movePossible.getMovePos() == 0);
	    	System.out.println("Abscissa choice :");
	    	char eX = getCoordinatesX.nextLine().charAt(0);
	
	    	System.out.println("Ordinate choice :");
	    	int eY = getCoordinatesY.nextInt();
	    	
	    	Position end = new Position((int) (eX-65),(eY-1));
	        this.moveBall(begin, end);
    }
    
    /**
     * Move the ball.
     * @param start The start position of the ball
     * @param end The final position of the ball
     */
    private void moveBall(Position start, Position end) {
    	if(this.gameBoard.getCase(start).getBall() == Color.OTHER){
    		System.out.println("Aucune boule");
    	}
    	else{
    		this.gameBoard.getCase(end).putBall(this.gameBoard.getCase(start).getBall());
    		this.gameBoard.getCase(start).removeBall();
    	}
    }

}
