package fr.iut.valence.tpdd.projet.abalone;

/**
 * Abalone board.
 *
 * @author blouinm and bouhassa
 * @version 1.0
 */
public class Board {
    /** Width of the board. */
    public static final int BOARD_WIDTH = 9;
    /** Array of type Case. */
    private final Case[][] board;

    /** Creation of a board. */
    public Board() {
        this.board = new Case[BOARD_WIDTH][BOARD_WIDTH];
        this.boardInitialization();
    }


    
    /**
     * Initialization of the board with cases.
     *
     * @see Case
     * @see Position
     */
    private void boardInitialization() {
        for (int rowNumber = 0; rowNumber < BOARD_WIDTH; rowNumber++) {
            for (int columnNumber = 0; columnNumber < BOARD_WIDTH; columnNumber++) {
                this.board[rowNumber][columnNumber] = new Case(new Position(rowNumber, columnNumber));
                if(rowNumber < 3){
                	this.board[rowNumber][columnNumber].putBall(Color.WHITE);
                }
                if(rowNumber > 5){
                	this.board[rowNumber][columnNumber].putBall(Color.BLACK);
                }
            }
        }
        for(int rowNumber = 0 ; rowNumber < 4; rowNumber++){
        	for(int columnNumber = (5+rowNumber); columnNumber < 9; columnNumber++){
        		this.board[rowNumber][(columnNumber)].putBall(Color.VOID);
        		this.board[8-rowNumber][(columnNumber)].putBall(Color.VOID);
        	}
        }
        
    }
    
    /**
     * Get the Case at the position
     * @param posCase the position of the Case desired
     * @return the Case at the position
     */
    public Case getCase(Position posCase){
    	return this.board[posCase.getAbscissa()][posCase.getOrdinate()];
    }
    
    
    /** Get the Array of Case of this board
     * @return the board
     */
    public Case[][] getBoard(){
    	return this.board;
    }

    @Override
    public String toString() {
        String representation = "           1  2  3  4  5 \n";
        for (int rowNumber = 0; rowNumber < BOARD_WIDTH; rowNumber++) {
        	if(rowNumber == 0 || rowNumber == 8) representation+= "\n     ";
        	if(rowNumber == 1 || rowNumber == 7) representation+= "\n    ";
        	if(rowNumber == 2 || rowNumber == 6) representation+= "\n   ";
        	if(rowNumber == 3 || rowNumber == 5) representation+= "\n ";
        	if(rowNumber == 4) representation+= "\n";
            char lettre = (char)(65+rowNumber);
            representation += lettre+"   ";
            for (int columnNumber = 0; columnNumber < BOARD_WIDTH; columnNumber++) {
                if (this.board[rowNumber][columnNumber].getBall() == Color.OTHER) {
                    representation += "( )";
                }
                if (this.board[rowNumber][columnNumber].getBall() == Color.VOID) {
                    representation += "";
                }
                if (this.board[rowNumber][columnNumber].getBall() == Color.WHITE) {
                    representation += "(W)";
                }
                if (this.board[rowNumber][columnNumber].getBall() == Color.BLACK) {
                    representation += "(B)";
                }
            }
        }
        return representation;
    }
}
