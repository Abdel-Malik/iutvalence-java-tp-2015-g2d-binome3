package fr.iut.valence.tpdd.projet.abalone;

/**
 * Position (x and y).
 *
 * @author blouinm and bouhassa
 * @version 1.0
 * @see Case
 */
public class Position {
    /* TODO Translate. */
    /** Position in axe-X of the point. */
    private final int abscisse;
    /* TODO Translate. */
    /** Position in axe-Y of the point. */
    private final int ordonnee;

    /** Create a new position. */
    public Position(int x, int y) {
        this.abscisse = x;
        this.ordonnee = y;
    }

    /* TODO Translate. */

    /**
     * Return the abscisse.
     *
     * @return abscisse of the position.
     */
    public int getAbscisse() {
        return this.abscisse;
    }

    /* TODO Translate. */
    /**
     * Return ordonnee.
     *
     * @return ordonnee of the position.
     */
    public int getOrdonnee() {
        return this.ordonnee;
    }
}
