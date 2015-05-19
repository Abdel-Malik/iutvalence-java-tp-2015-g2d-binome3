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
    public void nbBall() throws WrongBallSelectedException, WrongDeplacementChooseException{ 
    	System.out.println("How many ball would you move ?");
    	int numberOfBall = nbBallMoving.nextInt();
    	if(numberOfBall == 1){
			selectOneBall();
    	}
    	if(numberOfBall == 2){
    		selectTwoBalls();
    	}
    }
    
    
    /**
     * Take abscissa and ordinate.
     * @return position
     */
    private Case selectABall() {
    	Position ballSelected;
    	
    	System.out.println("\n\nAbscissa choice :");
    	char bX = getCoordinatesX.nextLine().charAt(0);

    	System.out.println("Ordinate choice :");
    	int bY = getCoordinatesY.nextInt();
    	if( (int)(bX-65) <= 4 ){
    		ballSelected = new Position((int) (bX-65),(bY-1));
    	}
    	else{
    		ballSelected = new Position((int) (bX-65),((bY-1))-((int) (bX-65))+4);
    	}
    	
    	return this.gameBoard.getCase(ballSelected);
    }
    
    
	/**
	 * move just 1 ball.
	 * 
     * @throws WrongBallSelectedException
     */
    private void selectOneBall() throws WrongBallSelectedException, WrongDeplacementChooseException{ 
    	Move movePossible;
    	Case begin;
    	Case end;
    	do{
	    	begin = this.selectABall();
	    	
	    	if(begin.getBall() != this.currentPlayer.getPlayerColor()){
	    		throw new WrongBallSelectedException();
	    	}
	    	
	
	    	movePossible = new Move(begin, this);
	    	
	    	if(movePossible.getMovePos() == 0){
	    		System.out.println("Aucun deplacement possible, choisissez une autre boule");
	    	}
	    	else{
	    		System.out.println("Deplacement possible : ");
	    		for(int a=0;a< movePossible.getMovePos();a++){
	    			System.out.println(movePossible.getMovingPossibility(a));
	    		}
    			System.out.println("Boules meme couleurs : ");
		    		for(int a=0;a<movePossible.getfriendlyPos();a++){
		    			System.out.println(movePossible.getSameBallPosition(a));
	    		}
		    	System.out.println("Boules adverses  : ");
		    	for(int a=0;a<movePossible.getEnnemyPos();a++){
		    		System.out.println(movePossible.getEnnemyPosition(a));    		
		    		}
	    	}
    	}while(movePossible.getMovePos() == 0);
    	
	    	System.out.println("Abscissa choice :");
	    	char eX = getCoordinatesX.nextLine().charAt(0);
	
	    	System.out.println("Ordinate choice :");
	    	int eY = getCoordinatesY.nextInt();

	    	if( (int)(eX-65) <= 4 ){
	    		end = this.gameBoard.getCase(new Position((int) (eX-65),(eY-1)));
	    	}
	    	else{
	    		end = this.gameBoard.getCase(new Position((int) (eX-65),((eY-1))-((int) (eX-65))+4));
	    	}
	    	
	    	if(!deplacementCorrect(end, movePossible)){
	    		throw new WrongDeplacementChooseException();
	    	}
	    	else{
	    		this.moveBall(begin, end);
	    	}
    }
    
    public boolean deplacementCorrect(Case caseAVerifier, Move movePossible){
    	for(int index = 0; index < movePossible.getMovePos();index++){
    		if(caseAVerifier.getPosition().getAbscissa() != movePossible.getMovingPossibility(index).getAbscissa() || caseAVerifier.getPosition().getOrdinate() != movePossible.getMovingPossibility(index).getOrdinate()){
    			return false;
    		}
    	}
    	return true;
    }
    
    
    private void selectTwoBalls() throws WrongBallSelectedException{
    	Move movePossible;
    	Case ballOne;
    	do{
	    	ballOne = this.selectABall();
	    	
	    	if(ballOne.getBall() != this.currentPlayer.getPlayerColor()){
	    		throw new WrongBallSelectedException();
	    	}
	    	
	    	movePossible = new Move(ballOne, this);
	    	
	    	if(movePossible.getMovePos() == 0){
	    		System.out.println("Aucun d�placement possible, choisissez une autre boule");
	    	}
	    	else{
	    		System.out.println("D�placement possible : ");
	    		for(int a=0;a< movePossible.getMovePos();a++){
	    			System.out.println(movePossible.getMovingPossibility(a));
	    		}
	    	}
    	}while(movePossible.getMovePos() == 0);
		
	}

    
    /**
     * Move the ball.
     * @param start The start position of the ball
     * @param end The final position of the ball
     */
    private void moveBall(Case start, Case end) {
    	if(start.getBall() == Color.OTHER){
    		System.out.println("Aucune boule");
    	}
    	else{
    		end.putBall(start.getBall());
    		start.removeBall();
    	}
    }
    
    public void launchGame(){
    	System.out.println(getBoard());
        while(true){
        	System.out.println("\nTurn : "+(getNbTurn()+1)+"\nPlayer "+getCurrentPlayer().getPlayerNumber() + "\ncolor - "+getCurrentPlayer().getPlayerColor());
        	try{
        		nbBall();
        	} catch (WrongBallSelectedException e) {
				System.out.println("Wrong ball selected isn't your color, retry...");
				continue;
			} catch (WrongDeplacementChooseException e){
				System.out.println("Wrong destination choosen, retry...");
				continue;
			}
        	increaseNbTurn();
        	System.out.println(getBoard());
        	changeCurrentPlayer();
        }
    }

}
