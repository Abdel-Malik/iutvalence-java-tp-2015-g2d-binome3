package fr.iut.valence.td2d.projet.abalone;

/**
 * Case du plateau.
 *
 * @author blouinm et bouhassa
 * @version 1.0
 */
public class Case {
    /* TODO JAVADOC. */
    private final Position positionCase;
    /* TODO JAVADOC. */
    private       Couleur  couleurDeCase;

    /* TODO Comment est initialisé votre case ? */
    /* TODO Vous devriez initialiser explicitement couleurDeCase. */

    /**
     * Constructeur de cases.
     */
    public Case(Position position) {
        this.positionCase = position;
    }

    /**
     * Poser une boule.
     *
     * @param couleur Couleur de la boule
     */
    public void poserBoule(Couleur couleur) {
        this.couleurDeCase = couleur;
    }

    /**
     * Enlever la boule présente.
     */
    public void enleverBoule() {
        this.couleurDeCase = Couleur.AUTRE;
    }

    /**
     * Renvoie la boule de la case.
     *
     * @return la boule contenu par la case
     */
    public Couleur obtenirBoule() {
        return this.couleurDeCase;
    }

    /**
     * Renvoie la position de la case.
     *
     * @return la position de la case
     */
    public Position obtenirPosition() {
        return this.positionCase;
    }
}
