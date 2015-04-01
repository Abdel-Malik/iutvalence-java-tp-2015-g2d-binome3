package fr.iut.valence.td2d.projet.abalone;

/**
 * Position sur le plateau.
 *
 * @author blouinm et bouhassa
 * @version 1.0
 * @see Case
 */
public class Position {
    /* TODO JAVADOC. */
    private final int abscisse;
    /* TODO JAVADOC. */
    private final int ordonnee;

    /**
     * Création d'une position.
     *
     * @param x Abscisse
     * @param y Ordonnée
     */
    public Position(int x, int y) {
        this.abscisse = x;
        this.ordonnee = y;
    }

    /**
     * Renvoie l'abscisse.
     *
     * @return l'abscisse de la position
     */
    public int obtenirAbscisse() {
        return this.abscisse;
    }

    /**
     * Renvoie l'ordonnée.
     *
     * @return l'ordonnée de la position
     */
    public int obtenirOrdonnee() {
        return this.ordonnee;
    }

}
