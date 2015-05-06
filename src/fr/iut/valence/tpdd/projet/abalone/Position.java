package fr.iut.valence.tpdd.projet.abalone;

/**
 * Position (x and y).
 *
 * @author blouinm and bouhassa
 * @version 1.0
 * @see Case
 */
public class Position {

    /** Position in axe-X of the point. */
    private final char abscissa;

    /** Position in axe-Y of the point. */
    private final int ordinate;

    /**Create a new position.
     * 
     * @param x abscissa
     * @param y ordinate
     */
    public Position(char x, int y) {
        this.abscissa = x;
        this.ordinate = y;
    }

    /**
     * Return the abscissa.
     *
     * @return abscissa of the position.
     */
    public char getAbscissa() {
        return this.abscissa;
    }

    /**
     * Return ordinate.
     *
     * @return ordinate of the position.
     */
    public int getOrdinate() {
        return this.ordinate;
    }
    
    
    /**
     * 
     * @param coordinates
     * @return
     */
    public static Case getCase(Position coordinates, Board board){ //TODO THROWS
    	for(int rowBoardNumber=0;rowBoardNumber < Board.BOARD_WIDTH;rowBoardNumber++){
    		for(int columnBoardNumber=0;columnBoardNumber < Board.BOARD_WIDTH; columnBoardNumber++){
    			if(board.getBoard()[rowBoardNumber][columnBoardNumber].getPosition().equals(coordinates)){
    				return board.getBoard()[rowBoardNumber][columnBoardNumber];
    			}
    		}
    	}
		return null;
    }

	@Override
	public boolean equals(Object obj) { //TODO Redefinir méthode 
		
		return super.equals(obj);
	}

	@Override
	public int hashCode() { //TODO Redéfinir méthode
		// TODO Auto-generated method stub
		return super.hashCode();
	}
    
    
}
