package fr.iut.valence.tpdd.projet.abalone;

/** Case of the board.
 * 
 * @author blouinm and bouhassa
 * @version 1.0
 */
public class Case {
	
    /** The position of the case on the board.
     * 
     */
    private final Position positionCase;

    /** The color of the case.
     * 
     */
    private Color caseColor;

    /**Case constructor.
     * 
     * @param position The position of the case
     */
    public Case(Position position) {
        this.positionCase = position;
        this.caseColor = Color.OTHER;
    }

    /**Put a ball on the board.
     *
     * @param color  color of the ball
     */
    public void putBall(Color color) {
        this.caseColor = color;
    }

    /** Remove ball. 
     * Erase the ball contain by the case
     */
    public void removeBall() {
        this.caseColor = Color.OTHER;
    }

    /** Take ball. 
     *  Obtain the ball of the case. 
     * @return ball contain by the case
     */
    public Color getBall() {
        return this.caseColor;
    }

    /** get position. 
     *  Obtain the position of the case
     * @return the position of the case
     */
    public Position getPosition() {
        return this.positionCase;
    }
}
