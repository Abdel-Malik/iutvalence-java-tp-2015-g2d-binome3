package fr.iut.valence.tpdd.projet.abalone;

/**
 * array of position linked to a ball.
 * @author bouhassa
 *
 */
public class Move {
	
	/** number max of position for a ball.
	 */
	public final static int MAXIMUM_NUMBER_POSITION = 6;
	
	/** The 6 possible movement.
	 */
	public final static Position[] ABSOLUTE_POSITION = new Position[] {new Position(1,0),new Position(0,1),new Position(1,1),new Position(-1,0),new Position(0,-1),new Position(-1,-1)};
	
	/** array of empty position in the board.
	 */
	private Position[] relativePositionEmpty;
	
	/**size of the empty array.
	 */
	private int currentMovingPossibility;
	
	
	/** array of position in the board which have a ball of the same color than the ball taken in parameter.
	 */
	private Position[] relativePosSameColor;
	/**size of the same colorBall array.
	 */
	private int currentSameColor;
	
	
	/** array of position in the board which have a ball of the other color than the ball taken in parameter.
	 */
	private Position[] relativePosEnnemy;
	/**size of the other colorBall array.
	 */
	private int currentEnemyColor;

	
	/** the game. 
	 */
	private Game currentGame;
	
	
	public Move(Position ball, Game game){
		this.relativePositionEmpty = new Position[MAXIMUM_NUMBER_POSITION];
		this.relativePosSameColor = new Position[MAXIMUM_NUMBER_POSITION];
		this.relativePosEnnemy = new Position[MAXIMUM_NUMBER_POSITION];
		int indexEmpty = 0;
		int indexSame = 0;
		int indexOther = 0;
		this.currentGame = game;
		for(int numberPosition = 0; numberPosition < MAXIMUM_NUMBER_POSITION; numberPosition++){
			Position currentTry = new Position(ball.getAbscissa()+ABSOLUTE_POSITION[numberPosition].getAbscissa(),ball.getOrdinate()+ABSOLUTE_POSITION[numberPosition].getOrdinate());
			if(checkIfEmpty(numberPosition, ball)){
				this.relativePositionEmpty[indexEmpty]= currentTry;
				indexEmpty++;
			}
			if(checkIfSameColor(numberPosition, ball)){
				this.relativePosSameColor[indexSame] = currentTry;
				indexSame++;
			}
			if(checkIfEnnemyColor(numberPosition, ball)){
				this.relativePosEnnemy[indexOther] = currentTry;
				indexOther++;
			}
			this.currentMovingPossibility = indexEmpty;
			this.currentSameColor = indexSame;
			this.currentEnemyColor = indexOther;
		}
	}
	
	/**
	 * 
	 * @param nbPos
	 * @param ball
	 * @return
	 */
	private boolean checkIfEmpty(int nbPos, Position ball){
		if(((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()) >= 0) && ((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()) < Board.BOARD_WIDTH)){
			if(((ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()) >= 0) && ((ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()) < Board.BOARD_WIDTH)){ 
				if(this.currentGame.getBoard().getCase(new Position((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()),(ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()))).getBall() == Color.OTHER){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param nbPos
	 * @param ball
	 * @return
	 */
	private boolean checkIfSameColor(int nbPos, Position ball){
		if(this.currentGame.getBoard().getCase(new Position((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()),(ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()))).getBall() == this.currentGame.getCurrentPlayer().getPlayerColor()){
					return true;
		}
		return false;
	}
	
	private boolean checkIfEnnemyColor(int nbPos, Position ball){
		if(this.currentGame.getBoard().getCase(new Position((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()),(ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()))).getBall() != this.currentGame.getCurrentPlayer().getPlayerColor()){
			if(this.currentGame.getBoard().getCase(new Position((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()),(ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()))).getBall() != Color.OTHER){
				if(this.currentGame.getBoard().getCase(new Position((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()),(ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()))).getBall() != Color.VOID){
					return true;
				}
			}
		}
		return false;
	}
	
	public Position getMovingPossibility(int a){
		return this.relativePositionEmpty[a];
	}
	public Position getSameBallPosition(int a){
		return this.relativePosSameColor[a];
	}
	
	public Position[] getTab(){
    	return this.relativePositionEmpty;
	}
	
	public int getMovePos(){
		return this.currentMovingPossibility;
	}
}
