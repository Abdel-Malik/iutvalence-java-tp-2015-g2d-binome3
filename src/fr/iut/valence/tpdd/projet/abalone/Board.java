package fr.iut.valence.tpdd.projet.abalone;

/**
 * Abalone board.
 *
 * @author blouinm and bouhassa
 * @version 1.0
 */
public class Board {
    /** Width of the board. */
    private static final int BOARD_WIDTH = 9;
    /** Array of type Case. */
    private final Case[][] board;

    /** Creation of a board. */
    public Board() {
        this.board = new Case[BOARD_WIDTH][BOARD_WIDTH];
        this.boardInitialization();
    }

    /**
     * Move Ball.
     *
     * @param start Case of start
     * @param end   Case of end
     */
    public static void moveBall(Case start, Case end) {
        end.putBall(start.getBall());
        start.removeBall();
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

    @Override
    public String toString() {
        String representation = "       5  6  7  8  9 \n\n";
        for (int rowNumber = 0; rowNumber < BOARD_WIDTH; rowNumber++) {
        	if(rowNumber == 0 || rowNumber == 8) representation+= "     ";
        	if(rowNumber == 0) representation+= "4   ";
        	if(rowNumber == 1 || rowNumber == 7) representation+= "    ";
        	if(rowNumber == 1) representation+= "3   ";
        	if(rowNumber == 2 || rowNumber == 6) representation+= "   ";
        	if(rowNumber == 2) representation+="2   ";
        	if(rowNumber == 3 || rowNumber == 5) representation+= " ";
        	if(rowNumber == 3) representation+= " 1  ";
        	if(rowNumber == 4) representation+= "    ";
        	if(rowNumber > 4) representation+= "    ";
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
            char lettre = (char)(65+rowNumber);
            representation += "   "+lettre+"\n";
        }
        return representation;
    }
}
