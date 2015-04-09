package fr.iut.valence.tpdd.projet.abalone;

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
    private       int    nbTurn;
    /** The current player of the game. */
    private       Player currentPlayer;

    /**
     * Create a new party with the players.
     * TODO Why provide a "board" parameter.
     *
     * @param p1    The first player
     * @param p2    The second player
     * @param board The board of the game
     */
    public Game(Player p1, Player p2, Board board) {
        this.player1 = p1;
        this.player2 = p2;
        this.gameBoard = board;
        this.nbTurn = DEFAULT_TURN;
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
}
