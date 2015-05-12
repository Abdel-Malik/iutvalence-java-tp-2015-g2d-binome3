package fr.iut.valence.tpdd.projet.abalone;

public class Move {
	public final static int MAXIMUM_NUMBER_POSITION = 6;
	public final static Position[] ABSOLUTE_POSITION = new Position[] {new Position(1,0),new Position(0,1),new Position(1,1),new Position(-1,0),new Position(0,-1),new Position(-1,-1)};
	private Position[] relativePosition;
	private int currentMovingPossibility;
	private Game currentGame;
	
	public Move(Position ball, Game game){
		this.relativePosition = new Position[MAXIMUM_NUMBER_POSITION];
		int index = 0;
		this.currentGame = game;
		for(int numberPosition = 0; numberPosition < MAXIMUM_NUMBER_POSITION; numberPosition++){
			if(verification(numberPosition, ball)){
				this.relativePosition[index]= new Position(ball.getAbscissa()+ABSOLUTE_POSITION[numberPosition].getAbscissa(),ball.getOrdinate()+ABSOLUTE_POSITION[numberPosition].getOrdinate()) ;
				index++;
			}
			this.currentMovingPossibility = index;
		}
	}
	
	private boolean verification(int nbPos, Position ball){
		if(((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()) >= 0) && ((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()) < Board.BOARD_WIDTH)){
			if(((ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()) >= 0) && ((ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()) < Board.BOARD_WIDTH)){ 
				if(this.currentGame.getBoard().getCase(new Position((ball.getAbscissa()+ABSOLUTE_POSITION[nbPos].getAbscissa()),(ball.getOrdinate()+ABSOLUTE_POSITION[nbPos].getOrdinate()))).getBall() == Color.OTHER){
					return true;
				}
			}
		}
		return false;
	}
	
	public Position getMovingPossibility(int a){
		return this.relativePosition[a];
	}
	
	public Position[] getTab(){
    	return this.relativePosition;
	}
	
	public int getMovePos(){
		return this.currentMovingPossibility;
	}
}
