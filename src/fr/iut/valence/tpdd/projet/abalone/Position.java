package fr.iut.valence.tpdd.projet.abalone;

/** Position. 
 * @author blouinm and bouhassa
 * @version 1.0
 * @see Case
 */
public class Position {
    /**position in axe-X of the point.
     * 
     */
    private final int abscisse;
    /**Position in axe-Y of the point.
     * 
     */
    private final int ordonnee;

    /**Creation of a position. 
     * @param x Abscisse
     * @param y Ordonnée
     */
    public Position(int x, int y) {
        this.abscisse = x;
        this.ordonnee = y;
    }

    /** Return the abscisse. 
     *
     * @return abscisse of the position.
     */
    public int getAbscisse() {
        return this.abscisse;
    }

    /** return ordonnee
     *
     * @return ordonnee of the position.
     */
    public int getOrdonnee() {
        return this.ordonnee;
    }

}
