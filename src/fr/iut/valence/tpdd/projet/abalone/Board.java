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
            }
        }
    }

    @Override
    public String toString() {
        String representation = "";
        for (int rowNumber = 0; rowNumber < BOARD_WIDTH; rowNumber++) {
            for (int columnNumber = 0; columnNumber < BOARD_WIDTH; columnNumber++) {
                if (this.board[rowNumber][columnNumber].getBall() == Color.OTHER) {
                    representation += "( )";
                }
            }
            representation += "\n";
        }
        return representation;
    }
}
